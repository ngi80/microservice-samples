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

2 When installed start mongo using:
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




