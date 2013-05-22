package ironpeace.batchapp.gsBatch.theGroupingSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.operator.GroupingSampleOperatorImpl;
/**
 * {@code [pre->GroupingSampleOperator.convertToResult(operator#1579795854)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment3 implements Result<PreResult> {
    private final Result<PreResult> original;
    private final Result<ironpeace.modelgen.dmdl.model.Result> out;
    private GroupingSampleOperatorImpl op = new GroupingSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code GroupingSampleOperator.convertToResult#original}への出力
     * @param out {@code GroupingSampleOperator.convertToResult#out}への出力
     */
    public MapFragment3(Result<PreResult> original, Result<ironpeace.modelgen.dmdl.model.Result> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(PreResult result) {
        ironpeace.modelgen.dmdl.model.Result v = this.op.convertToResult(result);
        this.original.add(result);
        this.out.add(v);
    }
}