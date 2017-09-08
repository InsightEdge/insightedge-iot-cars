. common.sh


pushd ..

echo "Deploy events space"

export XAP_LOOKUP_LOCATORS=127.0.0.1:8888

echo ""
echo "      Deploying events space"
echo ""

$GS_HOME/bin/gs.sh deploy events-space/target/magic-events-space.jar

echo ""
echo "      Deploying events gateway"
echo ""

$GS_HOME/bin/gs.sh deploy events-gateway/target/magic-events-gateway.jar

popd