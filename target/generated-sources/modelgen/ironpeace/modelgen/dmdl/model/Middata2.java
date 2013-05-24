package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
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
            "userid", "alert"}) public class Middata2 implements DataModel<Middata2>, Writable {
    private final StringOption userid = new StringOption();
    private final StringOption alert = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.userid.setNull();
        this.alert.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(Middata2 other) {
        this.userid.copyFrom(other.userid);
        this.alert.copyFrom(other.alert);
    }
    /**
     * useridを返す。
     * @return userid
     * @throws NullPointerException useridの値が<code>null</code>である場合
     */
    public Text getUserid() {
        return this.userid.get();
    }
    /**
     * useridを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setUserid(Text value) {
        this.userid.modify(value);
    }
    /**
     * <code>null</code>を許すuseridを返す。
     * @return userid
     */
    public StringOption getUseridOption() {
        return this.userid;
    }
    /**
     * useridを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setUseridOption(StringOption option) {
        this.userid.copyFrom(option);
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
        result.append(", userid=");
        result.append(this.userid);
        result.append(", alert=");
        result.append(this.alert);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + userid.hashCode();
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
        if(this.userid.equals(other.userid) == false) {
            return false;
        }
        if(this.alert.equals(other.alert) == false) {
            return false;
        }
        return true;
    }
    /**
     * useridを返す。
     * @return userid
     * @throws NullPointerException useridの値が<code>null</code>である場合
     */
    public String getUseridAsString() {
        return this.userid.getAsString();
    }
    /**
     * useridを設定する。
     * @param userid0 設定する値
     */
    @SuppressWarnings("deprecation") public void setUseridAsString(String userid0) {
        this.userid.modify(userid0);
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
        userid.write(out);
        alert.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        userid.readFields(in);
        alert.readFields(in);
    }
}