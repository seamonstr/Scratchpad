import org.hibernate.annotations.GenericGenerator;
import org.redcabbage.garden.model.Bed;
import org.redcabbage.garden.model.Plant;
import org.redcabbage.garden.model.Species;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.redcabbage.garden.model.Bed.GardenLocation.back;

public class JPA {
    private static EntityManager em;
    private static EntityManagerFactory fact;
    static {
    }

    public static void main(String[] args) {
        fact = Persistence.createEntityManagerFactory("garden");
        em = fact.createEntityManager();

        Bed b = new Bed(-1, "New Bed again!", back);
        saveInstance(b);

        Species s = new Species();
        s.setName("triffid");
        saveInstance(s);

        Plant p = new Plant();
        p.setBed(b);
        p.setSpecies(s);
        p.setHeight(56);
        saveInstance(p);

        em.close();
        fact.close();
    }

    static private <T> void saveInstance(T entity) {
      em.getTransaction().begin();
      try {
        em.persist(entity);
      } finally {
        em.getTransaction().commit();
      }
    }
}
