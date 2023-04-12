package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Random;

@Singleton
@Startup
public class InitStudent {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    @EJB
    private StudentFacade studentFacade;

    @PostConstruct
    public void init() {
        System.out.println("### Initializing Student Entities");

/*
        Student student = new Student("1", "Ass", "NIANG", 76.0);

        entityManager.persist(student);
*/
        if (studentFacade.count()>0){
            return;
        }
        String[] firstnames = {"Moussa", "Ass", "Salimata"};
        String[] lastnames = {"DIOP", "NDIAYE", "SALL"};
        int nbStudents = 20;
        Random random = new Random();

        for (int i = 0; i < nbStudents; i++) {
            String firstname = firstnames[random.nextInt(firstnames.length)];
            String lastname = lastnames[random.nextInt(lastnames.length)];
            Double weight = random.nextDouble() * 50.0 + 50.0;
            String number = "dic2_"+(i+1);

            Student student = new Student(number,firstname,lastname,weight);
            studentFacade.create(student);
        }
    }
}
