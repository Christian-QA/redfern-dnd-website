package com.qa.dnd;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class DungeonsDragonsCharacterSheetTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void appMainTest()
    {
        DungeonsDragonsCharacterSheet app = new DungeonsDragonsCharacterSheet();
        String[] args = null;
        DungeonsDragonsCharacterSheet.main(args);
        assertTrue( app instanceof DungeonsDragonsCharacterSheet );
    }
}
