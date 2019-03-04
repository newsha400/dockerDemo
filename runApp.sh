gcloud compute --project=phrasal-clover-201314 firewall-rules create allow-medstack --direction=INGRESS --priority=1000 --network=default --action=ALLOW --rules=tcp:2375 --source-ranges=107.139.198.10 --target-tags=medstack
mvn clean install
java -jar target/dockerDemo-0.0.1-SNAPSHOT.jar


