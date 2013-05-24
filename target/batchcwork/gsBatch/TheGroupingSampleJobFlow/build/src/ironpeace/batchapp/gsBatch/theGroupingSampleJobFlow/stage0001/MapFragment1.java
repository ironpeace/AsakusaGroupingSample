package ironpeace.batchapp.gsBatch.theGroupingSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.operator.GroupingSampleOperator;
import ironpeace.operator.GroupingSampleOperatorImpl;
/**
 * {@code [originaldata->GroupingSampleOperator.balance(operator#1579795854)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<OriginalData> {
    private final Result<OriginalData> before;
    private final Result<OriginalData> current;
    private final Result<OriginalData> old;
    private GroupingSampleOperatorImpl op = new GroupingSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param before {@code GroupingSampleOperator.balance#before}への出力
     * @param current {@code GroupingSampleOperator.balance#current}への出力
     * @param old {@code GroupingSampleOperator.balance#old}への出力
     */
    public MapFragment1(Result<OriginalData> before, Result<OriginalData> current, Result<OriginalData> old) {
        this.before = before;
        this.current = current;
        this.old = old;
    }
    @Override public void add(OriginalData result) {
        GroupingSampleOperator.Term v = this.op.balance(result);
        switch(v) {
            case BEFORE:
                this.before.add(result);
                break;
            case CURRENT:
                this.current.add(result);
                break;
            case OLD:
                this.old.add(result);
                break;
            default:
                throw new AssertionError(v);
        }
    }
}