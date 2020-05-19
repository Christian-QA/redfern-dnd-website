package com.qa.mesadnd;


import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import static org.junit.Assert.assertTrue;

@TestPropertySource(locations= "classpath:test.properties")
public class MesaDNDTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        MesaDND mesaDND = new MesaDND ();
        String[] args = null;
        MesaDND.main(args);
        assertTrue( mesaDND instanceof MesaDND);
    }
}
