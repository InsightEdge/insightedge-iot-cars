. common.sh


pushd ..

echo "Deploy events space"

export XAP_LOOKUP_LOCATORS=localhost:4174

echo ""
echo "      Deploying events space"
echo ""

$GS_HOME/bin/gs.sh deploy version2/events-space/target/magic-events-space-version2.jar

echo ""
echo "      Deploying events gateway"
echo ""

$GS_HOME/bin/gs.sh deploy version2/events-gateway/target/magic-events-gateway-version2.jar

popd