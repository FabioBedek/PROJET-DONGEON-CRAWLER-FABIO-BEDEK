import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine  {

    @Override
    public void update() {
        repaint();
    }

    public void setRenderList(ArrayList<Displayable> renderList) {
        this.renderList = renderList;
    }

    private ArrayList<Displayable> renderList;


    public RenderEngine() {
        this.renderList = new ArrayList<>();
    }
    public void addToRenderList(Displayable displayable) {
        this.renderList.add(displayable);
    }
    public void paint(Graphics g){
        super.paint(g);
        for (Displayable displayable : renderList) {
            displayable.draw(g);
        }
    }
}