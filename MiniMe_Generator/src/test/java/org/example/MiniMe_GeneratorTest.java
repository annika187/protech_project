package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiniMe_GeneratorTest {
    @Test
    public void bmiBerechnen(){
        double bmi1 = MiniMe_Generator.bmiBerechnen(190,80);
        double bmi2 = MiniMe_Generator.bmiBerechnen(170,60);

        assertEquals(22.16, bmi1);
        assertEquals(20.76, bmi2);
    }
}