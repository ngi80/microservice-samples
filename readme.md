# Microservice Training

## Training 1 - Create a microservice

This step describes how to create a simple Rest Service connecting to its own mongo database.

The technologies in use are :

* Spring Boot
* mongodb

## Step 0 - prerequisites
To be able to complete this training you need:
* jdk 8+
* maven

## Step 1 - Configure the database

1 install mongodb  - if not the case go to [mongodb](https://www.mongodb.org/)

2 When installed start mongo using:<parent>
                                           <groupId>org.springframework.cloud</groupId>
                                           <artifactId>spring-cloud-starter-parent</artifactId>
                                           <version>Angel.SR6</version>
                                       </parent>
```
> mongod
```
3 In a new terminal connect to mongo shell:
 ```
> mongo
 ```
4 Create the "todos" database:
```
> use todos
```

At the end of this step you should have a mongodb installed locally.
Check it by typing in the mongodb shell this command :
```
> show dbs
```

## Step 2 - Project Structure

```
*
|
|___pom.xml
|___/todo-services
    |___pom.xml     *info: project parent pom*
    |___/src
        |___/main
        |    |___/java
        |    |    |___/com.todo.service
        |    |    |    |___Application.java     *info: *
        |    |    |    |___/api
        |    |    |    |    |___ToDoRestService.java
        |    |    |    |___/data
        |    |    |        |___/config
        |    |    |        |    |___MongoConfig.java
        |    |    |        |___/model
        |    |    |        |    |___ToDo.java
        |    |    |________|___/service
        |    |                |___ToDoService
        |    |                |___MongoToDoService
        |    |                |___/framework
        |    |                    |___ServiceFactory.java
        |    |                    |___ServiceSelector.java
        |    |___/resources
        |        |___application.yml
        |___/test
            |___/java
            |    |___/com.todo.service
            |        |___/api
            |           |___ToDoServiceTest.java
            |            |___/data.service
            |                |___/framework
            |                |    |___ServiceSelectorMongoDBIT.java
            |                |    |___ServiceSelectorOtherIT.java
            |                |___AnotherToDoService.java
            |___todo-service.jmx
```




