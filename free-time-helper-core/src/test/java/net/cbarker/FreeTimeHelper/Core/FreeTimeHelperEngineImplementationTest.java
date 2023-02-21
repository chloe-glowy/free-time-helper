package net.cbarker.FreeTimeHelper.Core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreeTimeHelperEngineImplementationTest {
    private FreeTimeHelperEngine engine;

    @BeforeEach
    void setUp() {
        this.engine = new FreeTimeHelperEngineImplementation();
    }

    @Test
    void getsTestPrompt() {
        List<Prompt> prompts = engine.getPrompts(1);
        assertEquals(prompts.get(0).text(), "Go climbing");
    }
}