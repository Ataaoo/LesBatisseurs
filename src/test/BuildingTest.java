package test;

import org.junit.*;
import static org.junit.Assert.*;
import model.Building;

public class BuildingTest {

    Building building;

    @Before
    public void setUp(){
        building = new Building("Building 1",2,2,2,2,2);
    }

    @After
    public void tearDown(){
        building = null;
    }

    @Test
    public void testBuilding(){
        assertNotNull(building);
    }

    @Test
    public void testGetWoodCost(){
        assertEquals(2,building.getWoodCost());
    }

    @Test
    public void testGetStoneCost(){
        assertEquals(2,building.getStoneCost());
    }

    @Test
    public void testGetTileCost(){
        assertEquals(2,building.getTileCost());
    }

    @Test
    public void testGetKnowledgeCost(){
        assertEquals(2,building.getKnowledgeCost());
    }

    @Test
    public void testGetCoinReward(){
        assertEquals(2,building.getCoinReward());
    }

    @Test
    public void testSetWoodCost(){
        building.setWoodCost(8);
        assertEquals(8,building.getWoodCost());
    }

    @Test
    public void testSetStoneCost(){
        building.setStoneCost(8);
        assertEquals(8,building.getStoneCost());
    }

    @Test
    public void testSetTileCost(){
        building.setTileCost(8);
        assertEquals(8,building.getTileCost());
    }

    @Test
    public void testSetKnowledgeCost(){
        building.setKnowledgeCost(8);
        assertEquals(8,building.getKnowledgeCost());
    }

    @Test
    public void testSetCoinReward(){
        building.setCoinReward(8);
        assertEquals(8,building.getCoinReward());
    }

    @Test
    public void testIsFinished(){
        building.setIsFinished(false);
        assertFalse(building.isFinished());

        building.setIsFinished(true);
        assertTrue(building.isFinished());
    }
}
