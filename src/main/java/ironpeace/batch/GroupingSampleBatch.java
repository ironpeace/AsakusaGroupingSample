package ironpeace.batch;

import ironpeace.jobflow.GroupingSampleJobFlow;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;

@Batch(name="gsBatch")
public class GroupingSampleBatch extends BatchDescription {

	@Override
	protected void describe() {
		run(GroupingSampleJobFlow.class).soon();
	}

}
