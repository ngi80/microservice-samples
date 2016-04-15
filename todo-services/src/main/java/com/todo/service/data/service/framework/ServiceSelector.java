package com.todo.service.data.service.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nicolasgilmant on 13/04/16.
 */
@Component
public class ServiceSelector<T>
{
    @Autowired
    private ServiceFactory serviceFactory;

    @Value("${datalayer.selector.property}")
    private String selectorProperty;

    private T service;

    @PostConstruct
    public void postConstruct()
    {
        service = (T) serviceFactory.getServiceImplementation(selectorProperty);
    }

    public T getService() {
        return service;
    }
}
