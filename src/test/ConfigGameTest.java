package test;

import model.Board;
import model.Mode;
import org.junit.*;
import static org.junit.Assert.*;
import model.ConfigGame;

import java.io.IOException;
import java.util.Scanner;

public class ConfigGameTest {

    ConfigGame configGame;

    @Before
    public void setUp() throws IOException {
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
    public void testConfigure() throws IOException {
        //Configure va lancer startMenu() qui va soit demander tous les paramètres ou load() pour recuperer depuis un fichier serializable
        configGame.startMenu(new Scanner(System.in));

    }


}
