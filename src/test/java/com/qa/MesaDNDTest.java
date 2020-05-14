package com.qa;

import com.qa.mesadnd.MesaDND;
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
