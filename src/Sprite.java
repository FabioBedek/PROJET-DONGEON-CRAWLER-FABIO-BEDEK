import java.awt.*;
import java.awt.image.BufferedImage;


public class Sprite implements Displayable{
    protected double x;
    protected double y;
    protected final Image image;
    protected double width = 0;
    protected double height = 0;

    public Sprite(double x, double y, Image image, double width, double height) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,(int)x,(int)y,null);
    }
}


