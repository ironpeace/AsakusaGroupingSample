package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import ironpeace.modelgen.dmdl.model.Term2012;
import java.io.IOException;
/**
 * <code>term2012</code>をTSVなどのレコード形式で出力する。
 */
public final class Term2012Output implements ModelOutput<Term2012> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public Term2012Output(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(Term2012 model) throws IOException {
        emitter.emit(model.getKeycodeOption());
        emitter.emit(model.getUseridOption());
        emitter.emit(model.getTermOption());
        emitter.emit(model.getDataOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}