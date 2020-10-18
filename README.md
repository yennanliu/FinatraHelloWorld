# FinatraHelloWorld
> - Build REST API via Scala via Finatra framework
> - Finatra is an API framework build based on TwitterServer

### Quick start

- Get API
```bash
sbt run
# Multiple main classes detected, select one to run:

#  [1] com.twitter.server.BasicServer
#  [2] com.twitter.server.ExampleServerMain
 
curl localhost:8888
```
- Check the API : http://localhost:8888/ or http://localhost:8888/hello
- Check the admin page : http://localhost:9990/admin

- Post API
```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{ "id": 999, "name": "JACK"}' \
   localhost:8080/hi

# response
# ----> Hello JACK with id 999
```

### Build 
```bash
sbt compile
sbt assembly
```

### Run 
```bash

```

### Development

### Ref
- https://twitter.github.io/finatra/index.html
- Finatral tutorial
	- https://shekhargulati.com/2017/09/14/finatra-tutorial-building-scalable-services-the-twitter-way/
