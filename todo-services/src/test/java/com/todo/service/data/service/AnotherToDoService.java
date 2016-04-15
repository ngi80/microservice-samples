package com.todo.service.data.service;

import com.todo.service.data.model.ToDo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolasgilmant on 15/04/16.
 * Another data access service in replacement of the default MongoToDoService class.
 */
@Component("anotherService")
public class AnotherToDoService implements ToDoService
{
    public ToDo findToDo(final String toDoId)
    {
        return null;
    }

    public List<ToDo> getAll()
    {
        return null;
    }

    public void saveTodo(final ToDo todo)
    {
        ;
    }

    public void deleteTodo(final ToDo todo){
        ;
    }
}
