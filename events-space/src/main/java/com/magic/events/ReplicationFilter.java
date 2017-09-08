package com.magic.events;

import com.j_spaces.core.IJSpace;
import com.j_spaces.core.cluster.IReplicationFilter;
import com.j_spaces.core.cluster.IReplicationFilterEntry;
import com.j_spaces.core.cluster.ReplicationPolicy;
import com.magic.insightedge.model.CarEventDummy;

import java.util.logging.Logger;

/**
 * Created by Vitalii Zinchenko
 */
public class ReplicationFilter implements IReplicationFilter {

    private static Logger logger = Logger.getLogger(ReplicationFilter.class.getName());

    private IJSpace space;

    public void init(IJSpace space, String paramUrl, ReplicationPolicy replicationPolicy) {
        this.space = space;
    }

    public void process(int direction, IReplicationFilterEntry entry, String replicationTargetName) {
        try {
            logger.info("filter: " + entry.getClassName() + " ---- " + entry.getObject(space));
        } catch (Exception e) {
            logger.severe("Failed: " + e.getMessage());
        }
        if (isNotDummy(entry)) {
            entry.discard();
        }
    }

    private boolean isNotDummy(IReplicationFilterEntry entry) {
        return !entry.getClassName().equals(CarEventDummy.class.getName());
    }

    public void close() {
    }
}
