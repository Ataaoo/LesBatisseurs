package test;

import model.Board;
import model.Game;
import org.junit.*;
import static org.junit.Assert.*;
import model.AutoPlayer;

public class AutoPLayerTest {

    AutoPlayer autoPlayer;

    @Before
    public void setUp(){
        autoPlayer = new AutoPlayer("Antoine",new Board("","",""),null);
    }

    @After
    public void tearDown(){
        autoPlayer = null;
    }

    @Test
    public void testAutoPlayer(){
        assertNotNull(autoPlayer);
    }

    /*
    * On attendra le code de play pour tester son fonctionement
    * */

    @Test
    public void testGetName(){
        assertEquals("Antoine",autoPlayer.getName());
    }
}
