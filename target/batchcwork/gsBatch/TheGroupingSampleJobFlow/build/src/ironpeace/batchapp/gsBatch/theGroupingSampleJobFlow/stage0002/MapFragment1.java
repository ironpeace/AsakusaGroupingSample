package ironpeace.batchapp.gsBatch.theGroupingSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.operator.GroupingSampleOperatorImpl;
/**
 * {@code [mid1->GroupingSampleOperator.convertToMid2FromMid1(operator#546579839)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment1 implements Result<Middata1> {
    private final Result<Middata1> original;
    private final Result<Middata2> out;
    private GroupingSampleOperatorImpl op = new GroupingSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code GroupingSampleOperator.convertToMid2FromMid1#original}への出力
     * @param out {@code GroupingSampleOperator.convertToMid2FromMid1#out}への出力
     */
    public MapFragment1(Result<Middata1> original, Result<Middata2> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(Middata1 result) {
        Middata2 v = this.op.convertToMid2FromMid1(result);
        this.original.add(result);
        this.out.add(v);
    }
}