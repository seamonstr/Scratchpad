package org.redcabbage.garden;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redcabbage.garden.model.Bed;
import org.redcabbage.garden.model.Plant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadingBeansTest {
    static private ApplicationContext ctx;
    @BeforeAll
    public static void loadGardenContext() {
        ctx = new ClassPathXmlApplicationContext("gardenbeans.xml");
    }

    @Test
    public void loadFrontBed() {
        Bed bed = ctx.getBean("FrontByDoor", Bed.class);
        assertEquals(bed.getId(), 1);
        assertEquals(bed.getName(), "Front - by door");
        assertEquals(bed.getFrontOrBack(), Bed.GardenLocation.front);
    }

    @Test
    public void loadGraph() {
        Plant tree = ctx.getBean("BigTree", Plant.class);
        assertEquals(1, tree.getId());
        assertEquals("Back - left", tree.getBed().getName());
        assertEquals("Birch", tree.getSpecies().getName());
    }
}
