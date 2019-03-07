package org.redcabbage.garden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.redcabbage.garden.model.Bed;

import javax.persistence.*;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JPATest {
    private EntityManager em;
    private EntityManagerFactory fact;

    @BeforeEach
    public void openDB() throws IOException {
        Properties props = new Properties();
        props.load(ClassLoader.getSystemResourceAsStream("TestDB.properties"));
        fact = Persistence.createEntityManagerFactory("garden", props);
        em = fact.createEntityManager();
    }

    @AfterEach
    public void closeDB() {
        em.close();
        fact.close();
    }

    @Test
    public void testStuffHappens() {
        TypedQuery<Bed> qry = em.createQuery("select b from Bed b where b.id = 1000001", Bed.class);
        Bed b = qry.getSingleResult();
        assertEquals(b.getId(), 1000001);
        assertTrue(b.getName().equals("Bit beyond birdbath"));

    }
}
