. common.sh


pushd ..

echo "Deploy events space"

export XAP_LOOKUP_LOCATORS=localhost:4174

echo ""
echo "      Deploying events space"
echo ""

$GS_HOME/bin/gs.sh deploy events-space/target/events-space-1.0.0-SNAPSHOT.jar

echo ""
echo "      Deploying events gateway"
echo ""

$GS_HOME/bin/gs.sh deploy events-gateway/target/events-gateway-1.0.0-SNAPSHOT.jar

popd