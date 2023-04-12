package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentFacade extends AbstractFacade<Student>{

    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
