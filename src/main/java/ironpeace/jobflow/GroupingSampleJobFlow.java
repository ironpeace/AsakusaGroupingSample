package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.Result;
import ironpeace.operator.GroupingSampleOperatorFactory;
import ironpeace.operator.GroupingSampleOperatorFactory.Balance;
import ironpeace.operator.GroupingSampleOperatorFactory.ConvertToMid2FromMid1;
import ironpeace.operator.GroupingSampleOperatorFactory.ConvertToResult;
import ironpeace.operator.GroupingSampleOperatorFactory.Join4Mid1;
import ironpeace.operator.GroupingSampleOperatorFactory.Join4PreResult;

import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;

@JobFlow(name = "TheGroupingSampleJobFlow")
public class GroupingSampleJobFlow extends FlowDescription {
	
	final In<OriginalData> originaldata;
	final Out<Result> result;
	final CoreOperatorFactory coreOp = new CoreOperatorFactory();
	
	public GroupingSampleJobFlow(
				@Import(name="originaldata", description=OriginalDataFromCsv.class)
				In<OriginalData> originaldata,
				@Export(name="result", description=ResultToCsv.class)
				Out<Result> result
			){
		this.originaldata = originaldata;
		this.result = result;
	}

	@Override
	protected void describe() {
		GroupingSampleOperatorFactory operators
		 = new GroupingSampleOperatorFactory();
		
		Balance balance = operators.balance(originaldata);
		coreOp.stop(balance.old);
		
		Join4Mid1 join4mid1 = operators.join4Mid1(balance.before, balance.current);
		coreOp.stop(join4mid1.missed);

		ConvertToMid2FromMid1 convertedMid2 
			= operators.convertToMid2FromMid1(join4mid1.joined);
		coreOp.stop(convertedMid2.original);
		
		Join4PreResult join4PreResult
			= operators.join4PreResult(join4mid1.joined, convertedMid2.out);
		coreOp.stop(join4PreResult.missed);
		
		ConvertToResult convertedResult
			= operators.convertToResult(join4PreResult.joined);
		coreOp.stop(convertedResult.original);
		
		result.add(convertedResult.out);
	}

}
