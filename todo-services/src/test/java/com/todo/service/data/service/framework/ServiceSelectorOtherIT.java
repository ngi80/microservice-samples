package com.todo.service.data.service.framework;

import com.todo.service.Application;
import com.todo.service.data.service.AnotherToDoService;
import com.todo.service.data.service.DataServiceSelector;
import com.todo.service.data.service.ToDoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nicolasgilmant on 15/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@IntegrationTest("datalayer.selector.property=anotherService")
public class ServiceSelectorOtherIT {

    @Autowired
    private DataServiceSelector<ToDoService> toDoService;

    @Test
    public void TestServiceSelectorInitialization(){
        Assert.assertTrue(toDoService.getService() instanceof AnotherToDoService);
    }
}
