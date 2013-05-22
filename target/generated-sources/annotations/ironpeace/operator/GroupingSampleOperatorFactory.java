package ironpeace.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.MasterJoin;
import ironpeace.modelgen.dmdl.model.Middata1;
import ironpeace.modelgen.dmdl.model.Middata2;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;
import java.util.Arrays;
import javax.annotation.Generated;
/**
 * {@link GroupingSampleOperator}に関する演算子ファクトリークラス。
 * @see GroupingSampleOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1") public class GroupingSampleOperatorFactory {
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
        public final Source<OriginalData> missed;
        Join4Mid1(Source<OriginalData> t11, Source<OriginalData> t12) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(MasterJoin.class);
            builder.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "join4Mid1");
            builder.declareParameter(OriginalData.class);
            builder.declareParameter(OriginalData.class);
            builder.addInput("t11", t11, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addInput("t12", t12, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addOutput("joined", Middata1.class);
            builder.addOutput("missed", t12);
            builder.addAttribute(FlowBoundary.SHUFFLE);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("t11", t11);
            this.$.resolveInput("t12", t12);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.Join4Mid1 as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param t11
     * @param t12
     * @return 生成した演算子オブジェクト
     * @see GroupingSampleOperator#join4Mid1(OriginalData, OriginalData)
     */
    public GroupingSampleOperatorFactory.Join4Mid1 join4Mid1(Source<OriginalData> t11, Source<OriginalData> t12) {
        return new GroupingSampleOperatorFactory.Join4Mid1(t11, t12);
    }
    /**
     */
    public static final class Join4PreResult implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<PreResult> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<Middata2> missed;
        Join4PreResult(Source<Middata1> mid1, Source<Middata2> mid2) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterJoin.class);
            builder0.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "join4PreResult");
            builder0.declareParameter(Middata1.class);
            builder0.declareParameter(Middata2.class);
            builder0.addInput("mid1", mid1, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addInput("mid2", mid2, new ShuffleKey(Arrays.asList(new String[]{"keycode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addOutput("joined", PreResult.class);
            builder0.addOutput("missed", mid2);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("mid1", mid1);
            this.$.resolveInput("mid2", mid2);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.Join4PreResult as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * @param mid1
     * @param mid2
     * @return 生成した演算子オブジェクト
     * @see GroupingSampleOperator#join4PreResult(Middata1, Middata2)
     */
    public GroupingSampleOperatorFactory.Join4PreResult join4PreResult(Source<Middata1> mid1, Source<Middata2> mid2) {
        return new GroupingSampleOperatorFactory.Join4PreResult(mid1, mid2);
    }
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
            OperatorDescription.Builder builder1 = new OperatorDescription.Builder(Branch.class);
            builder1.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "balance");
            builder1.declareParameter(OriginalData.class);
            builder1.addInput("originaldata", originaldata);
            builder1.addOutput("before", originaldata);
            builder1.addOutput("current", originaldata);
            builder1.addOutput("old", originaldata);
            builder1.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder1.toResolver();
            this.$.resolveInput("originaldata", originaldata);
            this.before = this.$.resolveOutput("before");
            this.current = this.$.resolveOutput("current");
            this.old = this.$.resolveOutput("old");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName1 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.Balance as(String newName1) {
            this.$.setName(newName1);
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
    public static final class ConvertToMid2FromMid1 implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<Middata1> original;
        /**
         */
        public final Source<Middata2> out;
        ConvertToMid2FromMid1(Source<Middata1> mid1) {
            OperatorDescription.Builder builder2 = new OperatorDescription.Builder(Convert.class);
            builder2.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "convertToMid2FromMid1");
            builder2.declareParameter(Middata1.class);
            builder2.addInput("mid1", mid1);
            builder2.addOutput("original", mid1);
            builder2.addOutput("out", Middata2.class);
            builder2.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder2.toResolver();
            this.$.resolveInput("mid1", mid1);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName2 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.ConvertToMid2FromMid1 as(String newName2) {
            this.$.setName(newName2);
            return this;
        }
    }
    /**
     * @param mid1
     * @return 生成した演算子オブジェクト
     * @see GroupingSampleOperator#convertToMid2FromMid1(Middata1)
     */
    public GroupingSampleOperatorFactory.ConvertToMid2FromMid1 convertToMid2FromMid1(Source<Middata1> mid1) {
        return new GroupingSampleOperatorFactory.ConvertToMid2FromMid1(mid1);
    }
    /**
     */
    public static final class ConvertToResult implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<PreResult> original;
        /**
         */
        public final Source<Result> out;
        ConvertToResult(Source<PreResult> pre) {
            OperatorDescription.Builder builder3 = new OperatorDescription.Builder(Convert.class);
            builder3.declare(GroupingSampleOperator.class, GroupingSampleOperatorImpl.class, "convertToResult");
            builder3.declareParameter(PreResult.class);
            builder3.addInput("pre", pre);
            builder3.addOutput("original", pre);
            builder3.addOutput("out", Result.class);
            builder3.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder3.toResolver();
            this.$.resolveInput("pre", pre);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName3 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingSampleOperatorFactory.ConvertToResult as(String newName3) {
            this.$.setName(newName3);
            return this;
        }
    }
    /**
     * @param pre
     * @return 生成した演算子オブジェクト
     * @see GroupingSampleOperator#convertToResult(PreResult)
     */
    public GroupingSampleOperatorFactory.ConvertToResult convertToResult(Source<PreResult> pre) {
        return new GroupingSampleOperatorFactory.ConvertToResult(pre);
    }
}