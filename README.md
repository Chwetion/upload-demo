# upload-demo

This project base on springboot framework, it has a interface to upload file to server.

![structure](img/structure.png)

## Build

### Compile

``mvn clean && mvn -Dmaven.test.skip=true``

### Image

``docker build -f {projectDir}/Dockerfile -t {imageName}:{tag} {projectDir}``

## Configuration

When you run this container, you can use $JAVA_OPTS env set JVM configuration.

e.g. `-Dspring.config.location={applicationYamlFileUrl}` set out tree application.yml.

## Interface

- POST /upload Upload file to server, you need upload a file named file in form-data.