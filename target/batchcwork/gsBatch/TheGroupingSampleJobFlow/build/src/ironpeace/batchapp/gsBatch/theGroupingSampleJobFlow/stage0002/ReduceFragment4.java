package ironpeace.batchapp.gsBatch.theGroupingSampleJobFlow.stage0002;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.PreResult;
/**
 * {@code 
         * [mid1->GroupingSampleOperator.join4PreResult(operator#546579839), mid2->GroupingSampleOperator.join4PreResult(operator#546579839)]
         * }の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class ReduceFragment4 extends com.asakusafw.runtime.flow.Rendezvous<
        ShuffleValue> {
    private final Result<PreResult> joined;
    private final Result<Middata2> missed;
    private boolean sawMaster;
    private Middata1 cache = new Middata1();
    private PreResult cache0 = new PreResult();
    /**
     * インスタンスを生成する。
     * @param joined {@code GroupingSampleOperator.join4PreResult#joined}への出力
     * @param missed {@code GroupingSampleOperator.join4PreResult#missed}への出力
     */
    public ReduceFragment4(Result<PreResult> joined, Result<Middata2> missed) {
        this.joined = joined;
        this.missed = missed;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            case 2:
                this.process0002(value.getPort2());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.sawMaster = false;
    }
    @Override public void end() {
    }
    private void process0001(Middata1 value) {
        if(this.sawMaster == false) {
            this.cache.copyFrom(value);
            this.sawMaster = true;
        }
    }
    private void process0002(Middata2 value) {
        if(this.sawMaster) {
            this.cache0.reset();
            this.cache0.setKeycodeOption(this.cache.getKeycodeOption());
            this.cache0.setUseridOption(this.cache.getUseridOption());
            this.cache0.setTermOption(this.cache.getTermOption());
            this.cache0.setData0Option(this.cache.getData0Option());
            this.cache0.setData1Option(this.cache.getData1Option());
            this.cache0.setAlertOption(value.getAlertOption());
            this.joined.add(this.cache0);
        }
        else {
            this.missed.add(value);
        }
    }
}