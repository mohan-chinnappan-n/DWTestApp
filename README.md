# DWTestApp

### CREATING THE PROJECT USING MAVEN

```bash
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes \
                       -DarchetypeArtifactId=java-simple \
                       -DarchetypeVersion=1.2.2


Define value for property 'groupId': : org.mohansun.dev
        Define value for property 'artifactId': : DWTestApp
        Define value for property 'version':  1.0-SNAPSHOT: :
        Define value for property 'package':  org.mohansun.dev: :
        [INFO] Using property: description = null
        Define value for property 'name': : DWTestApp
        [INFO] Using property: shaded = true
        Confirm properties configuration:
        groupId: org.mohansun.dev
        artifactId: DWTestApp
        version: 1.0-SNAPSHOT
        package: org.mohansun.dev
        description: null
        name: DWTestApp
        shaded: true
```
How to start the DWTestApp application
---

```
$ cat DWTestApp.yml

template: Hello, %s!, Welcome!
defaultName: Ken
server:
      rootPath: /api/*

```

1. Run `mvn clean install` to build your application
2. Check the application `java -jar target/DWTestApp-1.0-SNAPSHOT.jar check DWTestApp.yml`

`INFO  [2018-03-09 19:12:20,177] io.dropwizard.cli.CheckCommand: Configuration is OK`

3. Start application with `java -jar target/DWTestApp-1.0-SNAPSHOT.jar server DWTestApp.yml`

4. To check that your application is running enter url `http://localhost:8080/api/hello-world`


``` json
// http://localhost:8080/api/hello-world

{
  "id": 1,
  "content": "Hello, Ken!, Welcome!"
}
```

```bash

$ curl http://localhost:8080/api/events | jq
[
  {
    "id": 1,
    "name": "Birthday",
    "description": "Please be on time!",
    "location": "221B Baker Street",
    "date": 1520637966499
  }
]

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

### Presentations

- [Dropwizard Introduction](https://mohan-chinnappan-n.github.io/fwk/dropwizard.html#/home)

### References
- [Building RESTful web services With Dropwizard](https://medium.com/@henslejoseph/building-restful-web-services-with-dropwizard-62175dad340e)
