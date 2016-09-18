package com.york.businesslogic;


import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.york.entity.*;

@Stateless
@DeclareRoles(value={"admin", "manager", "team-lead", "developer"})
public class TaskEntityFacade implements TaskEntityFacadeRemote {

    @PersistenceContext
    private EntityManager em;

    @RolesAllowed("manager")
    public void createTask(String name, String description) {

        TaskEntity newTaskEntity = new TaskEntity();
        newTaskEntity.setName(name);
        newTaskEntity.setDescription(description);
        newTaskEntity.setStatus("NEW");

        em.persist(newTaskEntity);
    }

    @RolesAllowed("team-lead")
    public void assignTask(Long taskId, String assignee){

        TaskEntity taskEntity = find(taskId);
        taskEntity.setAssignee(assignee);
        taskEntity.setStatus("ASSIGNED");
        em.persist(taskEntity);
    }

    @RolesAllowed("developer")
    public void completeTask(Long taskId){

        TaskEntity taskEntity = find(taskId);
        taskEntity.setStatus("COMPLETED");
        em.persist(taskEntity);
    }

    @RolesAllowed("admin")
    public void deleteAllTasks(){

        List<TaskEntity> allTasks = findAll();
        if (allTasks != null){
            for (TaskEntity aTask : allTasks){
                remove(aTask);
            }
        }
    }

    @PermitAll
    public List getAllTasks() {
        return em.createQuery("select object(o) from TaskEntity as o").getResultList();
    }

    public TaskEntity findByName(String name){
        return null;
    }

    public void create(TaskEntity taskEntity) {
        em.persist(taskEntity);
    }

    public void edit(TaskEntity taskEntity) {
        em.merge(taskEntity);
    }

    public void remove(TaskEntity taskEntity) {
        em.remove(em.merge(taskEntity));
    }

    public TaskEntity find(Object id) {
        return em.find(TaskEntity.class, id);
    }

    public List findAll() {
        return em.createQuery("select object(o) from TaskEntity as o").getResultList();
    }

}