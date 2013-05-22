package ironpeace.operator;

import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.MasterJoin;

import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.Term2011;
import ironpeace.modelgen.dmdl.model.Term2012;

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
	public abstract Middata1 join4Mid1(Term2011 t11, Term2012 t12);
}
