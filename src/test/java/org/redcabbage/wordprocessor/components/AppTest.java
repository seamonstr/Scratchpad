package org.redcabbage.wordprocessor.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/*
Test the autowired loading of my wordprocessor components
 */
class AppTest {
    AnnotationConfigApplicationContext ctx;

    @BeforeEach
    void loadAppCtx() {
        ctx = new AnnotationConfigApplicationContext(
                        "org.redcabbage.wordprocessor.components");
    }

    @Test
    void testLoading() {
        App app = ctx.getBean(App.class);
        assertNotNull(app, "no app loaded");
        assertNotNull(app.getEditor(), "no editor");
        assertNotNull(app.getFileBrowser(), "no fb");
        assertNotNull(app.getSpellChecker(), "no spelleck");
        assertNotNull(app.getToolBar(), "no toolbar");
    }

    @Test
    void testByIdAndClass() {
        assertSame(ctx.getBean("app"), ctx.getBean(App.class));
    }
}