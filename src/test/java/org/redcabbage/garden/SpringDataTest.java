package org.redcabbage.garden;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.redcabbage.garden.model.Bed;
import org.redcabbage.garden.model.BedRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class SpringDataTest {
    static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    public static void createContext() {
      ctx = new AnnotationConfigApplicationContext("org.redcabbage.garden");
    }

    @Test
    public void testLoadAllBeds() {
        BedRepository bedRepo = ctx.getBean("bedRepository", BedRepository.class);
        Iterable<Bed> it = bedRepo.findAll();
        for (Bed b: it)
            Logger.getAnonymousLogger().info(b.toString());
    }
}
