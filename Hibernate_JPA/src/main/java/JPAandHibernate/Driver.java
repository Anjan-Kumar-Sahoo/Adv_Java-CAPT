package JPAandHibernate;

import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new  Student(new StudentID(8402L,"aks.com"),"Anjan",22,new Address("Rourkela", "769003", 262),Arrays.asList("Java","SQL","Spring f.w"));
		Student s2 = new  Student(new StudentID(8402L,"av.com"),"Anjali",22,new Address("Rourkela", "769003", 5),Arrays.asList("Core Java","English"));
	
		et.begin();
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
}
