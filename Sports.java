import java.awt.*;

public class Sports extends Vehicle{ // sports car

    public Sports(int newx, int newy) {
        super(newx,newy);
        width = 40;
        height = 20;
        speed = 12;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
    }

}
