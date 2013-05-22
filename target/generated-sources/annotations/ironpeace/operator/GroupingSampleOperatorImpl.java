package ironpeace.operator;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import javax.annotation.Generated;
/**
 * {@link GroupingSampleOperator}に関する演算子実装クラス。
 */
@Generated("OperatorImplementationClassGenerator:0.0.1") public class GroupingSampleOperatorImpl extends 
        GroupingSampleOperator {
    /**
     * インスタンスを生成する。
     */
    public GroupingSampleOperatorImpl() {
        return;
    }
    @Override public Middata1 join4Mid1(OriginalData t11, OriginalData t12) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
    @Override public PreResult join4PreResult(Middata1 mid1, Middata2 mid2) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
}