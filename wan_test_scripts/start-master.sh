. common.sh

export XAP_LOOKUP_GROUPS="MASTER"

export XAP_LUS_OPTIONS=-Dcom.sun.jini.reggie.initialUnicastDiscoveryPort=8888
export XAP_LOOKUP_LOCATORS="127.0.0.1:8888"
export EXT_JAVA_OPTIONS=-Dcom.gs.multicast.enabled=false
nohup $GS_HOME/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 1 gsa.global.gsm 0 gsa.gsm 1 gsa.gsc 2 > $DEMO_LOG_DIR/xap-master.log 2>&1 &
