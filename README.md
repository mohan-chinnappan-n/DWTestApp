# DWTestApp

How to start the DWTestApp application
---

1. Run `mvn clean install` to build your application
2. Check the application `java -jar target/DWTestApp-1.0-SNAPSHOT.jar check DWTestApp.yml`

`INFO  [2018-03-09 19:12:20,177] io.dropwizard.cli.CheckCommand: Configuration is OK`
3. Start application with `java -jar target/DWTestApp-1.0-SNAPSHOT.jar server DWTestApp.yml`
4. To check that your application is running enter url `http://localhost:8080/hello-world`

``` json
// http://localhost:8080/hello-world

{
  "id": 1,
  "content": "Hello, Ken!"
}
```

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

```json
// http://localhost:8081/healthcheck

{
  "deadlocks": {
    "healthy": true
  },
  "template": {
    "healthy": true
  }
}
```
