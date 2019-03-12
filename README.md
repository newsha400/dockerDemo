# dockerDemo

Steps to see the project
  
Project owner should add a firewall rule, replace <public_IP> with the public IP address of the source  
`gcloud compute --project=phrasal-clover-201314 firewall-rules create allow-medstack --direction=INGRESS --priority=1000 --network=default --action=ALLOW --rules=tcp:2375 --source-ranges=<public_IP> --target-tags=medstack`
  
build the project using maven  
`mvn clean install`  
  
run the jar file  
`java -jar target/dockerDemo-0.0.1-SNAPSHOT.jar`  
  
go to the browser and see the result in following address  
`http://localhost:8080/dockerps`
  
To see the results in HTML format, either open /frontEnd/public/docker.html in your browser
  
Or to see it on a server do  
`cd frontEnd`  
`npm install`  
`npm start`  
  
Then open the page in 
`http://localhost:3000/`
