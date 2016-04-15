package com.todo.service.data.service.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by nicolasgilmant on 13/04/16.
 */
@Component
public class ServiceFactory {

    @Autowired
    ApplicationContext context;

    public Object getServiceImplementation(String qualifier){
        return context.getBean(qualifier);
    }
}
