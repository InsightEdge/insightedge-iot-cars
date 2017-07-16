. env.sh

echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"

GS_HOME=$INSIGHTEDGE_HOME/datagrid

export XAP_LOOKUP_GROUPS="SLAVE"


export XAP_LUS_OPTIONS=-Dcom.sun.jini.reggie.initialUnicastDiscoveryPort=9999
export XAP_LOOKUP_LOCATORS="127.0.0.1:9999"
export EXT_JAVA_OPTIONS=-Dcom.gs.multicast.enabled=false
$GS_HOME/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 1 gsa.global.gsm 0 gsa.gsm 1 gsa.gsc 2
