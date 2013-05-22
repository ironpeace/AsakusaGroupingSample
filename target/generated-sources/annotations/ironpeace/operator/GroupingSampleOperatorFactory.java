package ironpeace.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.MasterJoin;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.Term2011;
import ironpeace.modelgen.dmdl.model.Term2012;
import java.util.Arrays;
import javax.annotation.Generated;
/**
 * {@link GroupingSampleOperator}に関する演算子ファクトリークラス。
 * @see GroupingSampleOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1") public class GroupingSampleOperatorFactory {
    /**
     */
    public static final class Balance implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<OriginalData> before;
        /**
         */
        public final Source<OriginalData> current;
        /**
         */
        public final Source<OriginalData> old;
        Balance(Source<OriginalData> originaldata) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(Branch.class);
            builder.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "balance");
            builder.declareParameter(OriginalData.class);
            builder.addInput("originaldata", originaldata);
            builder.addOutput("before", originaldata);
            builder.addOutput("current", originaldata);
            builder.addOutput("old", originaldata);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("originaldata", originaldata);
            this.before = this.$.resolveOutput("before");
            this.current = this.$.resolveOutput("current");
            this.old = this.$.resolveOutput("old");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.Balance as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param originaldata
     * @return 生成した演算子オブジェクト
     * @see GroupingSampleOperator#balance(OriginalData)
     */
    public GroupingSampleOperatorFactory.Balance balance(Source<OriginalData> originaldata) {
        return new GroupingSampleOperatorFactory.Balance(originaldata);
    }
    /**
     */
    public static final class Join4Mid1 implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<Middata1> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<Term2012> missed;
        Join4Mid1(Source<Term2011> t11, Source<Term2012> t12) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterJoin.class);
            builder0.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "join4Mid1");
            builder0.declareParameter(Term2011.class);
            builder0.declareParameter(Term2012.class);
            builder0.addInput("t11", t11, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addInput("t12", t12, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addOutput("joined", Middata1.class);
            builder0.addOutput("missed", t12);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("t11", t11);
            this.$.resolveInput("t12", t12);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.Join4Mid1 as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * @param t11
     * @param t12
     * @return 生成した演算子オブジェクト
     * @see GroupingSampleOperator#join4Mid1(Term2011, Term2012)
     */
    public GroupingSampleOperatorFactory.Join4Mid1 join4Mid1(Source<Term2011> t11, Source<Term2012> t12) {
        return new GroupingSampleOperatorFactory.Join4Mid1(t11, t12);
    }
}