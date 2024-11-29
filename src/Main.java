import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Main{

    JFrame displayZoneFrame;
    RenderEngine renderEngine;
    GameEngine gameEngine;
    PhysicEngine physicEngine;



    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        displayZoneFrame.setVisible(true);


        DynamicSprite hero = new DynamicSprite(200,250, ImageIO.read(new File("./img/heroTileSheetLowRes.png")),48,50);



//      Sprite test = new Sprite(200,300,ImageIO.read(new File("./img/tree.png")),64,64);
//      renderEngine.addToRenderList(test);

        renderEngine = new RenderEngine();
        physicEngine = new PhysicEngine();
        gameEngine = new GameEngine(hero);

        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update());
        Timer physicTimer = new Timer(50,(time)-> physicEngine.update());

        renderTimer.start();
        gameTimer.start();
        physicTimer.start();


        displayZoneFrame.getContentPane().add(renderEngine);
        displayZoneFrame.setVisible(true);


        Playground level = new Playground("./data/level1.txt");

//      SolidSprite testSprite = new SolidSprite(100,100,test,0,0);
        renderEngine.setRenderList(level.getSpriteList());
        renderEngine.addToRenderList(hero);
        physicEngine.addToMovingSpriteList(hero);
        physicEngine.setEnvironment(level.getSolidSpriteList());

        displayZoneFrame.addKeyListener(gameEngine);
    }

 //   public static void main(String[] args) {
 //     System.out.println("Hello world!");

 //     }




    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }
}

