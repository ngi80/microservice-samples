package com.todo.service.data.service.framework;

import com.todo.service.Application;
import com.todo.service.data.service.MongoToDoService;
import com.todo.service.data.service.ToDoService;
import com.todo.service.data.service.framework.ServiceSelector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nicolasgilmant on 15/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ServiceSelectorMongoDBIT {

    @Autowired
    private ServiceSelector<ToDoService> toDoService;


    @Test
    public void TestServiceSelectorInitialization(){
        Assert.assertTrue(toDoService.getService() instanceof MongoToDoService);
    }

}
