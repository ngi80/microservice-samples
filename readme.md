[![Build Status](https://travis-ci.org/ngi80/microservice-samples.svg?branch=master)](https://travis-ci.org/ngi80/microservice-samples)

# Microservice Samples

Full TODO List Micro Services Stack.
The Goal is to explore Micro Services Architecture

The technologies in use are :

* Spring Boot, Cloud
* mongodb

## Prerequisites
To be able to run this sample you need:
* jdk 8+
* maven

## Configure the database

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

## Project modules

* [todo-config-server](todo-config-server)
* [config-repo](config-repo)
* [todo-services](todo-services)

