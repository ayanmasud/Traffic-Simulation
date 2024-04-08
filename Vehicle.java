import java.awt.*;

public class Vehicle { // parent of the type of cars. allows you to access the different cars and their variables through this class

    int x;
    int y;
    int width = 0;
    int height = 0;
    int speed = 0;

    public Vehicle(int newx, int newy) {
        x = newx;
        y = newy;
    }

    public void paintMe(Graphics g) {

    }

    public int getX() {
        return x;
    }

    public void setX(int newx) {
        x = newx;
    }

    public int getSpeed() {
        return speed;
    }

    public int getY() {
        return y;
    }

    public void setY(int newy) {
        y = newy;
    }

    public int getWidth() {
        return width;
    }

}
