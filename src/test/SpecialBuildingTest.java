package test;

import model.SpecialBuilding;
import org.junit.*;
import static org.junit.Assert.*;

public class SpecialBuildingTest {

    SpecialBuilding specialBuilding;

    @Before
    public void setUp(){
        specialBuilding = new SpecialBuilding("Tour Eiffel",10,10,10,10,10,2,2,2,2);
    }

    @After
    public void tearDown(){
        specialBuilding = null;
    }

    @Test
    public void testSpecialBuilding(){
        assertNotNull(specialBuilding);
    }

    @Test
    public void testGetWoodProduced(){
        assertEquals(2,specialBuilding.getWoodProduced());
    }

    @Test
    public void testGetStoneProduced(){
        assertEquals(2,specialBuilding.getStoneProduced());
    }

    @Test
    public void testGetTileProduced(){
        assertEquals(2,specialBuilding.getTileProduced());
    }

    @Test
    public void testGetKnowledgeProduced(){
        assertEquals(2,specialBuilding.getKnowledgeProduced());
    }

    @Test
    public void testSetWoodProduced(){
        specialBuilding.setWoodProduced(5);
        assertEquals(5,specialBuilding.getWoodProduced());
    }

    @Test
    public void testSetStoneProduced(){
        specialBuilding.setStoneProduced(5);
        assertEquals(5,specialBuilding.getStoneProduced());
    }

    @Test
    public void testSetTileProduced(){
        specialBuilding.setTileProduced(5);
        assertEquals(5,specialBuilding.getTileProduced());
    }

    @Test
    public void testSetKnowledgeProduced(){
        specialBuilding.setKnowledgeProduced(5);
        assertEquals(5,specialBuilding.getKnowledgeProduced());
    }


}
