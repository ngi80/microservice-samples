package com.todo.service.data.service;

import com.todo.service.data.service.framework.ServiceSelector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * Created by nicolasgilmant on 9/05/16.
 */
@Component
public class DataServiceSelector<T> extends ServiceSelector<T>
{

    @Value("${datalayer.selector.property}")
    public void setSelectorProperty(final String selectorProperty){
        this.selectorProperty = selectorProperty;
    }

}
