package com.magic;

import com.j_spaces.core.IJSpace;
import com.j_spaces.core.cluster.IReplicationFilter;
import com.j_spaces.core.cluster.IReplicationFilterEntry;
import com.j_spaces.core.cluster.ReplicationPolicy;

/**
 * @author Vitalii Zinchenko
 */
public class TestFilter implements IReplicationFilter {

    public void init(IJSpace space, String paramUrl, ReplicationPolicy replicationPolicy) {
    }

    public void process(int direction, IReplicationFilterEntry replicationFilterEntry, String replicationTargetName) {
        String n = "FILTER3";
        System.out.println(n + " ----> filter - " + replicationFilterEntry.getClassName());
        if (!replicationFilterEntry.getClassName().equals("com.magic.insightedge.Event1")) {
            System.out.println(n + " ----> ("+replicationFilterEntry.getClassName()+") is not Event1");
            replicationFilterEntry.discard();
            System.out.println(n + " ----> ("+replicationFilterEntry.getClassName()+") was discarded");
        }
//        if (!replicationTargetName.equals("gateway:SLAVE")) {
//            System.out.println("FILTER ----> gateway is not slave");
//            replicationFilterEntry.discard();
//            System.out.println("FILTER ----> discarded");
//        }
    }

    public void close() {
    }
}
