package com.magic;

import com.j_spaces.core.IJSpace;
import com.j_spaces.core.cluster.IReplicationFilter;
import com.j_spaces.core.cluster.IReplicationFilterEntry;
import com.j_spaces.core.cluster.ReplicationOperationType;
import com.j_spaces.core.cluster.ReplicationPolicy;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author Vitalii Zinchenko
 */
@Component("testFilter")
public class TestFilter implements IReplicationFilter {

    private static final Logger LOG = Logger.getLogger(TestFilter.class.getName());

    @Lazy
    @Autowired
    private GigaSpace gigaSpace;

    private IJSpace space;

    public void init(IJSpace space, String paramUrl, ReplicationPolicy replicationPolicy) {
        this.space = space;
    }

    public void process(int direction, IReplicationFilterEntry replicationFilterEntry, String replicationTargetName) {
        LOG.info("Filtering object of class: " + replicationFilterEntry.getClassName() + " and event type: " + replicationFilterEntry.getOperationType());
        if (replicationFilterEntry.getOperationType() != ReplicationOperationType.WRITE || !replicationFilterEntry.getClassName().equals("com.magic.insightedge.model.CarEventCopy")) {
            LOG.info("Is not CarEventCopy, discarding");
            replicationFilterEntry.discard();
            LOG.info("Discarded");
            return;
        }

        LOG.info("Marking as replicated");
        gigaSpace.write(new RemoveCarEventCopyEvent((Integer) replicationFilterEntry.getFieldValue("ID")));
        LOG.info("Marked as replicated");
    }

    public void close() {
    }
}
