package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import ironpeace.modelgen.dmdl.model.OriginalData;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>original_data</code>を読み出す
 */
public final class OriginalDataInput implements ModelInput<OriginalData> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public OriginalDataInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(OriginalData model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getKeycodeOption());
        parser.fill(model.getUseridOption());
        parser.fill(model.getTermOption());
        parser.fill(model.getDataOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}