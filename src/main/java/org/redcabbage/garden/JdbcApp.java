package org.redcabbage.garden;

import org.redcabbage.garden.model.Bed;
import org.redcabbage.garden.org.redcabbage.garden.repos.BedRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class JdbcApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("org.redcabbage.garden");
        BedRepo repo = ctx.getBean("bedRepo", BedRepo.class);
        Bed bed = repo.getBed(1000001);
        Logger.getLogger("org.redcabbage.garden.JdbcApp").info(bed.toString());
    }
}
