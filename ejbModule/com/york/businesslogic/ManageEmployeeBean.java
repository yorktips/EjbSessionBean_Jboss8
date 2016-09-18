package com.york.businesslogic;


import com.york.entity.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ManageEmployeeBean implements EmployeeRemote {
	
	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;

	public ManageEmployeeBean() {
	}

	public boolean addEmployee(Employee employee ) {
		entityManager.persist(employee);
		return true;
	}
	
}




