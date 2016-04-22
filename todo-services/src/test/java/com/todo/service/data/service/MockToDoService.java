package com.todo.service.data.service;

import com.todo.service.data.model.ToDo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolasgilmant on 18/04/16.
 */
@Component("mongodb-mock")
public class MockToDoService implements ToDoService
{
    @Override
    public ToDo findToDo(String toDoId)
    {
        List<ToDo> toDoList = getAll();

        for(ToDo todo : toDoList){
            if(todo.getId().equals(toDoId)){
                return todo;
            }
        }
        return null;
    }

    @Override
    public List<ToDo> getAll()
    {
        ToDo aToDo = new ToDo();
        aToDo.setId("0001");
        aToDo.setContent("My ToDo");
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(aToDo);
        return toDoList;
    }

    @Override
    public void saveTodo(ToDo todo)
    {
    }

    @Override
    public void deleteTodo(ToDo todo) {
    }
}
