# FinatraHelloWorld
> - Build REST API via Scala via Finatra framework
> - Finatra is an API framework build based on TwitterServer

### Quick start

<details>
<summary>Quick start</summary>

## Basics

#### Get API : [FitmanAppGet.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppGet.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppGet
# test API
curl http://localhost:8080/wazzup
```
- Check the API : http://localhost:8080/wazzup or http://localhost:8080/hello
- Check the admin page : http://localhost:9990/admin

#### Post API : [FitmanAppPost.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppPost.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppPost
# test API
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
# test API
curl http://localhost:8080/foo
```
- Check the API : http://localhost:8080/foo   (`/foo` will redirect to `/bar`)

#### Json Patch API (dev) : [FitmanAppJSONPatchRequests.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppJSONPatchRequests.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppJSONPatchRequests
# test API
curl -X PATCH -H "Content-Type:application/json-patch+json" \
    -d '{"op":"copy","from":"/fruit","path":"/veggie"}' \
   localhost:8080/jsonPatch
```

## Advanced

#### Post-advanced API : [FitmanAppPostAdvanced.scala](https://github.com/yennanliu/FinatraHelloWorld/blob/master/src/main/scala/com/twitter/server/FitmanAppPostAdvanced.scala)
```bash
sbt assembly
java -cp target/scala-2.11/finatrahelloworld_2.11-1.0.jar com.twitter.server.FitmanAppPostAdvanced
# test API
curl -X POST -H "Content-Type: application/json" \
    -d '{ "sth": sth}' \
   localhost:8080/1.1/foo

curl localhost:8080/1.1/appendMultiplePrefixed

curl localhost:8080/1.1/freestyleWithHeader

curl -X POST -H "Content-Type: application/json" \
-d '{ "x": 100}' \
localhost:8080/post_basic/plus_100

curl -X POST -H "Content-Type: application/json" \
-d '{ "x": 100, "y":88}' \
localhost:8080/post_basic/sum
```

</details>

### Build 
```bash
sbt compile
sbt assembly
```

### Run 
- dev

### Development
- dev

### Ref
- https://twitter.github.io/finatra/index.html
- Finatral tutorial
	- https://shekhargulati.com/2017/09/14/finatra-tutorial-building-scalable-services-the-twitter-way/
