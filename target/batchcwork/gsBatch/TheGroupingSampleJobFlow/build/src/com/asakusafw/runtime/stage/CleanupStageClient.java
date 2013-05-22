package com.asakusafw.runtime.stage;
/**
 * A cleanup stage client.
 */
public final class CleanupStageClient extends AbstractCleanupStageClient {
    @Override protected String getBatchId() {
        return "gsBatch";
    }
    @Override protected String getFlowId() {
        return "TheGroupingSampleJobFlow";
    }
    @Override protected String getStageId() {
        return "cleanup";
    }
    @Override protected String getCleanupPath() {
        return "target/hadoopwork/${execution_id}";
    }
}