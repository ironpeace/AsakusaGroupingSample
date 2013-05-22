package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.IntOption;
import com.asakusafw.runtime.value.StringOption;
import ironpeace.modelgen.dmdl.io.Middata2Input;
import ironpeace.modelgen.dmdl.io.Middata2Output;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * middata2を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(Middata2Input.class)@ModelOutputLocation(Middata2Output.class)@PropertyOrder({
            "keycode", "alert"}) public class Middata2 implements DataModel<Middata2>, Writable {
    private final IntOption keycode = new IntOption();
    private final StringOption alert = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.keycode.setNull();
        this.alert.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(Middata2 other) {
        this.keycode.copyFrom(other.keycode);
        this.alert.copyFrom(other.alert);
    }
    /**
     * keycodeを返す。
     * @return keycode
     * @throws NullPointerException keycodeの値が<code>null</code>である場合
     */
    public int getKeycode() {
        return this.keycode.get();
    }
    /**
     * keycodeを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setKeycode(int value) {
        this.keycode.modify(value);
    }
    /**
     * <code>null</code>を許すkeycodeを返す。
     * @return keycode
     */
    public IntOption getKeycodeOption() {
        return this.keycode;
    }
    /**
     * keycodeを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setKeycodeOption(IntOption option) {
        this.keycode.copyFrom(option);
    }
    /**
     * alertを返す。
     * @return alert
     * @throws NullPointerException alertの値が<code>null</code>である場合
     */
    public Text getAlert() {
        return this.alert.get();
    }
    /**
     * alertを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlert(Text value) {
        this.alert.modify(value);
    }
    /**
     * <code>null</code>を許すalertを返す。
     * @return alert
     */
    public StringOption getAlertOption() {
        return this.alert;
    }
    /**
     * alertを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAlertOption(StringOption option) {
        this.alert.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=middata2");
        result.append(", keycode=");
        result.append(this.keycode);
        result.append(", alert=");
        result.append(this.alert);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + keycode.hashCode();
        result = prime * result + alert.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Middata2 other = (Middata2) obj;
        if(this.keycode.equals(other.keycode) == false) {
            return false;
        }
        if(this.alert.equals(other.alert) == false) {
            return false;
        }
        return true;
    }
    /**
     * alertを返す。
     * @return alert
     * @throws NullPointerException alertの値が<code>null</code>である場合
     */
    public String getAlertAsString() {
        return this.alert.getAsString();
    }
    /**
     * alertを設定する。
     * @param alert0 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlertAsString(String alert0) {
        this.alert.modify(alert0);
    }
    @Override public void write(DataOutput out) throws IOException {
        keycode.write(out);
        alert.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        keycode.readFields(in);
        alert.readFields(in);
    }
}