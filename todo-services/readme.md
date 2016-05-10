## TODO List Rest Service's connecting to its own mongo database.

## Project Structure

```

/todo-services
    |___pom.xml     -- info: project parent pom
    |___/src
        |___/main
        |    |___/java
        |    |    |___/com.todo.service
        |    |    |    |___Application.java      // Application Bootstrap
        |    |    |    |___/api
        |    |    |    |    |___ToDoRestService.java    // API Rest Controller End-Point
        |    |    |    |___/data
        |    |    |        |___/config
        |    |    |        |    |___MongoConfig.java    // Mongo DB global configuration
        |    |    |        |___/model
        |    |    |        |    |___ToDo.java       // Mongo document model
        |    |    |________|___/service
        |    |                |___ToDoService       // interface for accessing DB
        |    |                |___MongoToDoService  // MongoDB access implementation
        |    |                |___/framework        // Simple test I did to be able to load any service implementation in a generic way.
        |    |                |   |___ServiceFactory.java   // create a bean based on the qualifier name
        |    |                |    |___ServiceSelector.java  // generic multi-purpose service selector implementation.
        |    |                |___DataServiceSelector //Generic Data Access Service Selector - it defines the qualifier name of the data access implementation
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
            |___todo-service.jmx        // JMETER Performance Test Script.
```

