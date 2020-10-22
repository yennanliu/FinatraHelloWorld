# FinatraHelloWorld
> - Build REST API via Scala via Finatra framework
> - Finatra is an API framework build based on TwitterServer

### Quick start

<details>
<summary>Quick start</summary>

#### Get API : [FitmanAppGet.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppGet.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppGet
 
curl localhost:8888
```
- Check the API : http://localhost:8080/wazzup or http://localhost:8080/hello
- Check the admin page : http://localhost:9990/admin

#### Post API : [FitmanAppPost.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppPost.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppPost

curl -X POST -H "Content-Type: application/json" \
    -d '{ "id": 999, "name": "JACK"}' \
   localhost:8080/hi

# response
# ----> Hello JACK with id 999
```

#### Redirect API : [FitmanAppRedirect.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppRedirect.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppRedirect
 
```
- Check the API : http://localhost:8080/foo   (`/foo` will redirect to `/bar`)

</details>

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
