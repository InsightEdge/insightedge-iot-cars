. common.sh


pushd ..

echo "Deploy slave"

export XAP_LOOKUP_LOCATORS=127.0.0.1:9999
$GS_HOME/bin/gs.sh deploy slave-space/target/slave-space-1.0.0-SNAPSHOT.jar
$GS_HOME/bin/gs.sh deploy slave-gateway/target/slave-gateway-1.0.0-SNAPSHOT.jar

popd