package com.todo.service.data.service;

import com.todo.service.data.model.ToDo;

import java.util.List;

/**
 * Created by nicolasgilmant on 13/04/16.
 * ToDo Data Access Layer Service Contract.
 */
public interface ToDoService
{
    /**
     * Find a ToDo Item
     * @param toDoId
     * @return
     */
    ToDo findToDo(final String toDoId);

    /**
     * Get All ToDo Items
     * @return
     */
    List<ToDo> getAll();

    /**
     * Save a ToDo Item
     * @param todo
     */
    void saveTodo(final ToDo todo);


    /**
     * Delete ToDo Item
     * @param todo
     */
    void deleteTodo(final ToDo todo);
}
