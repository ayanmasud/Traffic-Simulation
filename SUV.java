import java.awt.*;

public class SUV extends Vehicle{ // suv car

    public SUV(int newx, int newy) {
        super(newx,newy);
        width = 60;
        height = 30;
        speed = 8;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x,y,width,height);
    }

}
