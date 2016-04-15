package com.todo.service.data.service;

import com.todo.service.data.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolasgilmant on 13/04/16.
 */
@Component("mongodb")
public class MongoToDoService implements ToDoService
{
    @Autowired
    private MongoTemplate mongoTemplate;


    public ToDo findToDo(final String toDoId)
    {
        return mongoTemplate.findById(toDoId, ToDo.class);
    }

    public List<ToDo> getAll()
    {
        return mongoTemplate.findAll(ToDo.class);
    }

    public void saveTodo(final ToDo todo)
    {
        mongoTemplate.save(todo);
    }

    public void deleteTodo(final ToDo todo){
        mongoTemplate.remove(todo);
    }
}
