. common.sh


pushd ..

echo "Deploy events space"

export XAP_LOOKUP_LOCATORS=localhost:4174

echo ""
echo "      Deploying events space"
echo ""

$GS_HOME/bin/gs.sh deploy events-space/target/magic-events-space.jar

echo ""
echo "      Deploying events gateway"
echo ""

$GS_HOME/bin/gs.sh deploy events-gateway/target/magic-events-gateway.jar

popd