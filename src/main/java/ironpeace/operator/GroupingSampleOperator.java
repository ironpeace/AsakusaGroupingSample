package ironpeace.operator;

import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.MasterJoin;

import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;

public abstract class GroupingSampleOperator {

	@Branch
	public Term balance(OriginalData originaldata){
		if(originaldata.getTerm() == 2011){
			return Term.BEFORE;
		}else if(originaldata.getTerm() == 2012){
			return Term.CURRENT;
		}else{
			return Term.OLD;
		}
	}
	
	public static enum Term { BEFORE, CURRENT, OLD }
	
	@MasterJoin
	public abstract Middata1 join4Mid1(OriginalData t11, OriginalData t12);
	
	private Middata2 mid2 = new Middata2();
	
	@Convert
	public Middata2 convertToMid2FromMid1(Middata1 mid1){
		if(mid1.getData0() < mid1.getData1()){
			mid2.setAlertAsString("A");
		}else{
			mid2.setAlertAsString("B");
		}
		return mid2;
	}
	
	@MasterJoin
	public abstract PreResult join4PreResult(Middata1 mid1, Middata2 mid2);

	private Result result = new Result();
	
	@Convert
	public Result convertToResult(PreResult pre){
		result.setKeycode(pre.getKeycode());
		result.setUserid(pre.getUserid());
		result.setData0(pre.getData0());
		result.setData1(pre.getData1());
		result.setAlert(pre.getAlert());
		return result;
	}
}
