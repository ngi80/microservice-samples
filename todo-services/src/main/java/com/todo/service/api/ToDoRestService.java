package com.todo.service.api;

import com.todo.service.data.model.ToDo;
import com.todo.service.data.service.ToDoService;
import com.todo.service.data.service.framework.ServiceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nicolasgilmant on 15/04/16.
 */
@RestController
@RequestMapping("/todo-service")
public class ToDoRestService {

    @Autowired
    private ServiceSelector<ToDoService> toDoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ToDo> getAll(){
        return toDoService.getService().getAll();
    }

    @RequestMapping(value = "/{todoId}", method = RequestMethod.GET)
    public ToDo getToDo(@PathVariable String todoId) {
        return toDoService.getService().findToDo(todoId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ToDo saveToDo(@RequestBody ToDo todo) {
        toDoService.getService().saveTodo(todo);
        return todo ;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ToDo updateToDo(@RequestBody ToDo todo) {
        toDoService.getService().saveTodo(todo);
        return todo;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteToDo(@RequestBody ToDo todo) {
        toDoService.getService().deleteTodo(todo);
    }
}
