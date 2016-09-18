package com.york.businesslogic;

import java.util.List;
import javax.ejb.Remote;
import com.york.entity.*;

@Remote
public interface TaskEntityFacadeRemote {

    void createTask(String name, String description);

    void assignTask(Long taskId, String assignee);

    void completeTask(Long taskId);

    List getAllTasks();

    void deleteAllTasks();

    void create(TaskEntity taskEntity);

    void edit(TaskEntity taskEntity);

    void remove(TaskEntity taskEntity);

    TaskEntity find(Object id);

    List findAll();

}