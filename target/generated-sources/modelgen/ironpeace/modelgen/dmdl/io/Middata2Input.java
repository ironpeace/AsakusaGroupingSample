package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import ironpeace.modelgen.dmdl.model.Middata2;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>middata2</code>を読み出す
 */
public final class Middata2Input implements ModelInput<Middata2> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public Middata2Input(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(Middata2 model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getUseridOption());
        parser.fill(model.getAlertOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}