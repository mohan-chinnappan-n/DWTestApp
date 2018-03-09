# DWTestApp

How to start the DWTestApp application
---

1. Run `mvn clean install` to build your application
2. Check the application `java -jar target/DWTestApp-1.0-SNAPSHOT.jar check DWAppTest.yml`
3. Start application with `java -jar target/DWTestApp-1.0-SNAPSHOT.jar server DWAppTest.yml`
4. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
