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
    |___pom.xml     -- info: project parent pom
    |___/src
        |___/main
        |    |___/java
        |    |    |___/com.todo.service
        |    |    |    |___Application.java      -- info: Application Bootstrap
        |    |    |    |___/api
        |    |    |    |    |___ToDoRestService.java    -- info: API Rest Controller End-Point
        |    |    |    |___/data
        |    |    |        |___/config
        |    |    |        |    |___MongoConfig.java    -- info: Mongo DB global configuration (rem: db connection access are configured in application.yml and use Spring Data)
        |    |    |        |___/model
        |    |    |        |    |___ToDo.java       -- info: Mongo document model
        |    |    |________|___/service
        |    |                |___ToDoService       -- info: interface for accessing DB
        |    |                |___MongoToDoService  -- info: MongoDB access implementation
        |    |                |___/framework        -- info: Simple test I did to be able to load the DB access implementation in a generic way (my objective is to be able to change the implementation at runtime...see next training)
        |    |                    |___ServiceFactory.java   -- info: create a bean based on the qualifier name
        |    |                    |___ServiceSelector.java  -- info: service selector implementation - used in this training only for db access.
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
            |___todo-service.jmx        -- info: JMETER Performance Test Script.
```




