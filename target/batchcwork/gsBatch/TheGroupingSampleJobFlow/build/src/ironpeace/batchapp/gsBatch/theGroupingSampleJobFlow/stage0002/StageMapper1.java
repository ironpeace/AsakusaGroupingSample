package ironpeace.batchapp.gsBatch.theGroupingSampleJobFlow.stage0002;
import com.asakusafw.runtime.flow.RuntimeResourceManager;
import com.asakusafw.runtime.flow.VoidResult;
import ironpeace.modelgen.dmdl.model.Middata1;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * {@code 
         * [in->padding(pseud#978391674){owner=FlowBlock&#64;472117691}, mid1->GroupingSampleOperator.convertToMid2FromMid1(operator#546579839){owner=FlowBlock&#64;472117691}]
         * }の処理を担当するマッププログラム。
 */
@SuppressWarnings("deprecation") public final class StageMapper1 extends Mapper<NullWritable, Middata1, ShuffleKey, 
        ShuffleValue> {
    private Middata1 cache = new Middata1();
    private RuntimeResourceManager runtimeResourceManager;
    private MapFragment1 line0;
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager = new RuntimeResourceManager(context.getConfiguration());
        this.runtimeResourceManager.setup();
        final MapOutputFragment1 shuffle = new MapOutputFragment1(context);
        this.line = new MapFragment2(shuffle);
        final MapOutputFragment2 shuffle0 = new MapOutputFragment2(context);
        this.line0 = new MapFragment1(new VoidResult<Middata1>(), shuffle0);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.runtimeResourceManager.cleanup();
        this.runtimeResourceManager = null;
        this.line0 = null;
        this.line = null;
    }
    @Override public void run(Context context) throws IOException, InterruptedException {
        this.setup(context);
        while(context.nextKeyValue()) {
            cache.copyFrom(context.getCurrentValue());
            this.line.add(cache);
            cache.copyFrom(context.getCurrentValue());
            this.line0.add(cache);
        }
        this.cleanup(context);
    }
}