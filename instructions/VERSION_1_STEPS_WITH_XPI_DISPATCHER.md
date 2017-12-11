# Deploy Kafka and Spark with InsightEdge

![](images/v1_diagram_2.jpg)

1.	Kill all java processes
1.	Move to Local scripts folder folder `cd /home/experian/demo/insightedge-iot-cars/scripts`
1.	Start Kafka
    - ./start-kafka.sh
1.	Start InshightEdge
    - ./start-insightedge.sh
1.	Now we can connect with the browser to:
    - http://13.90.100.177:8099/ InsighEdge management and Zeppelin
    - fill Groups: insightedge
    - and Locators: 127.0.0.1:4174

    ![](images/Deploy_Kafka_and_Spark_with_InsightEdge_v2_25_JUL.jpg)

    - `http://13.90.100.177:8090/ - / (Zeppelin)`

1.	Start Spark Job:
    - ./start-spark-streaming.sh
1.	Start producer:
    - ./start-kafka-producer-small-input.sh
1.	When the space is filled run Http XPI Dispatching:
    - ./start-xpi-dispatcher.sh
