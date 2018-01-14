Java RESTful Web Service (JAX-RS) demo project based [Jersey](https://jersey.github.io/) and 
[Jetty](http://www.eclipse.org/jetty/)

1. Run this project with jetty maven plugin:
    
    ```$mvn jetty:run```
2. Create an executable single jar file with all dependencies and run it:

    ```
    $mvn clean package
    $java -jar  target/jax-rs-server.jar 
    ```
3. Run http request:
    ```
    $curl -X GET http://localhost:8080/rest/get
    $curl -X POST -H "Content-Type: application/json" -d '{"username":"xyz","password":"xyz"}' http://localhost:8080/rest/post
    ```