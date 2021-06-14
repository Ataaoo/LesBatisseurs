package test;

import model.Board;
import model.Mode;
import org.junit.*;
import static org.junit.Assert.*;
import model.ConfigGame;

public class ConfigGameTest {

    ConfigGame configGame;

    @Before
    public void setUp(){
        configGame = new ConfigGame();
    }

    @After
    public void tearDown(){
        configGame = null;
    }

    @Test
    public void testConfigGame(){
        assertNotNull(configGame);
    }

    @Test
    public void testToString(){
        //teste si le type de retour est bien un string
        assertEquals("".getClass(),configGame.toString().getClass());
    }

    @Test
    public void testConfigure(){
        //Configure va lancer startMenu() qui va soit demander tous les paramètres ou load() pour recuperer depuis un fichier serializable
        configGame.startMenu();
        //teste si tous les noms contienent bien été initialisés
        assertNotNull(configGame.getName1());
        assertNotNull(configGame.getName2());
        assertNotNull(configGame.getName3());
        assertNotNull(configGame.getName4());

        //teste si le board a bien été initialisé / recupéré
        assertNotNull(configGame.getBoard());

        //teste si le mode a bien été initialisé
        assertNotNull(configGame.getMode());
    }

    @Test
    public void testGetName1(){
        configGame.startMenu();
        assertNotNull(configGame.getName1());
    }

    @Test
    public void testGetName2(){
        configGame.startMenu();
        assertNotNull(configGame.getName2());
    }

    @Test
    public void testGetName3(){
        configGame.startMenu();
        assertNotNull(configGame.getName3());

    }

    @Test
    public void testGetName4(){
        configGame.startMenu();
        assertNotNull(configGame.getName4());
    }

    @Test
    public void testGetBoard(){
        configGame.startMenu();
        assertNotNull(configGame.getBoard());
    }

    @Test
    public void testGetMode(){
        configGame.startMenu();
        assertNotNull(configGame.getMode());
    }

    @Test
    public void testSetName1(){
        configGame.setName1("Pierre");
        assertEquals("Pierre",configGame.getName1());
    }

    @Test
    public void testSetName2(){
        configGame.setName2("Eric");
        assertEquals("Eric",configGame.getName2());
    }

    @Test
    public void testSetName3(){
        configGame.setName3("Marc");
        assertEquals("Marc",configGame.getName3());
    }

    @Test
    public void testSetName4(){
        configGame.setName4("Paul");
        assertEquals("Paul",configGame.getName4());
    }


    @Test
    public void testSetBoard(){
        Board test = new Board();
        configGame.setBoard(test);
        assertEquals(test,configGame.getBoard());
    }

    @Test
    public void testSetMode(){
        configGame.setMode(Mode.AA);
        assertEquals(Mode.AA,configGame.getMode());
    }
}
