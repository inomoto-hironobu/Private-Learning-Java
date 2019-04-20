package site.saishin.library.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        persis
        EntityManager em = Persistence.createEntityManagerFactory("derby").createEntityManager();
        em.getTransaction().begin();
        for(int i = 0; i < 1000; i++) {
        	em.persist(new SampleEntity());
        }
        em.getTransaction().commit();
        System.out.println(em.createNamedQuery("count").getSingleResult().getClass());
    }
}
