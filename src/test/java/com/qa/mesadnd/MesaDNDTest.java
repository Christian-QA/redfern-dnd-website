package com.qa.mesadnd;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
