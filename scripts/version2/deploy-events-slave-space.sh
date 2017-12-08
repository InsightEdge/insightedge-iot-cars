. common.sh


pushd ..

echo "Deploy slave"

export XAP_LOOKUP_LOCATORS=127.0.0.1:9999
$GS_HOME/bin/gs.sh deploy version2/slave-space/target/slave-events-space-version2.jar
$GS_HOME/bin/gs.sh deploy version2/slave-gateway/target/slave-events-gateway-version2.jar

popd
