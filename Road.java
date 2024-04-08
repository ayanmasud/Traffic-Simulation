import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Road extends JPanel { // enhances the program visually and gets the program to actually do stuff

    final int LANE_HEIGHT = 120;
    final int ROAD_WIDTH = 800;
    ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
    int carCount = 0;

    public Road() {
        super();
    }

    public void addCar(Vehicle v) {
        cars.add(v);
    }

    public void paintComponent(Graphics g) { // draws road
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.white);
        for (int a = LANE_HEIGHT; a < LANE_HEIGHT * 4; a = a + LANE_HEIGHT) { // which lane
            for (int b = 0; b < getWidth(); b = b + 40) { // which line
                g.fillRect(b,a,30,5);
            }
        }
        // draw cars
        for (int a = 0; a < cars.size(); a++) {
            cars.get(a).paintMe(g);
        }
    }

    public void step() { // gets the vehicles to move
        for (int a = 0; a < cars.size(); a++) {
            Vehicle v = cars.get(a);
            if(collision(v.getX()+v.getSpeed(),v.getY(),v) == false) { // theres no collision
                v.setX(v.getX() + v.getSpeed());
                if (v.getX() > ROAD_WIDTH) { // if its past the right border, start again from the left
                    if(collision(0,v.getY(),v) == false) {
                        v.setX(0);
                        carCount++;
                    }
                }
            }
            else{ // car ahead, lane change!
                if(v.getY() > 40 &&
                        collision(v.getX(),v.getY()-LANE_HEIGHT,v) == false) {
                        v.setY(v.getY() - LANE_HEIGHT);
                }
                else if(v.getY() < 40 + 3 * LANE_HEIGHT &&
                        collision(v.getX(),v.getY()+LANE_HEIGHT,v) == false) {
                    v.setY(v.getY() + LANE_HEIGHT);
                }
            }
        }
    }

    public boolean collision(int x, int y, Vehicle v) { // detects collisions
        for (int a = 0; a < cars.size(); a++) {
            Vehicle u = cars.get(a);
            if(y == u.getY()) { // if in the same lane
                if(u.equals(v) == false) { // if not checking the same car
                    if(x < u.getX() + u.getWidth() && // left side is left of other cars right
                            x + v.getWidth() > u.getX()) { // right side is right of other cars left
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getCarCount() {
        return carCount;
    }

    public void resetCarCount() {
        carCount = 0;
    }

}
