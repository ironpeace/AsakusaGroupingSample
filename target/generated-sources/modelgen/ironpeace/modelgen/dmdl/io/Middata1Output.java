package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import ironpeace.modelgen.dmdl.model.Middata1;
import java.io.IOException;
/**
 * <code>middata1</code>をTSVなどのレコード形式で出力する。
 */
public final class Middata1Output implements ModelOutput<Middata1> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public Middata1Output(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(Middata1 model) throws IOException {
        emitter.emit(model.getUseridOption());
        emitter.emit(model.getData0Option());
        emitter.emit(model.getData1Option());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}