package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.Result;
import ironpeace.operator.GroupingSampleOperatorFactory;
import ironpeace.operator.GroupingSampleOperatorFactory.Balance;
import ironpeace.operator.GroupingSampleOperatorFactory.Join4Mid1;

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
		
		Join4Mid1 join4mid1 = operators.join4Mid1(balance.before, balance.current);

	}

}
