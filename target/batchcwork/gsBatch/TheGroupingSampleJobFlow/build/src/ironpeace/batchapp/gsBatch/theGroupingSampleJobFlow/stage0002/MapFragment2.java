package ironpeace.batchapp.gsBatch.theGroupingSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata1;
/**
 * {@code [in->padding(pseud#978391674)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment2 implements Result<Middata1> {
    private final Result<Middata1> out;
    /**
     * インスタンスを生成する。
     * @param out {@code padding#out}への出力
     */
    public MapFragment2(Result<Middata1> out) {
        this.out = out;
    }
    @Override public void add(Middata1 result) {
        this.out.add(result);
    }
}