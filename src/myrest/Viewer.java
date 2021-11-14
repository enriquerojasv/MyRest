package myrest;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rvenr
 */
public class Viewer extends Canvas implements Runnable {

    private final Canvas canvas;
    int rate;
    boolean paused = false;
    boolean stoped = false;
    Chef[] arrayChef;
    Client[] arrayClient;
    Table table;

    public Viewer(Dimension size, Chef[] arrayChef, Client[] arrayClient, Table table) {
        this.canvas = new Canvas();

        this.table = table;
        this.arrayChef = arrayChef;
        this.arrayClient = arrayClient;

        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);

    }

    public Canvas getCanvas() {
        return this;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    @Override
    public void paint(Graphics g) {

        //painting central table
        g.setColor(Color.black);
        g.fillRect(table.getEjeX(), table.getEjeY(), table.getSize1() + 30, table.getSize2());

        //painting chef's table
        g.setColor(Color.orange);
        g.fillRect(20, table.getEjeY(), table.getSize1(), table.getSize2());

        //painting client's table
        g.setColor(Color.ORANGE);
        g.fillRect(900, table.getEjeY(), table.getSize1(), table.getSize2());

        //painting chefs
        for (int i = 0; i < arrayChef.length; i++) {
            g.setColor(Color.white);
            g.fillRect(this.arrayChef[i].getEjeX(), this.arrayClient[i].getEjeY()
                    + i + 70 * i + 1, this.arrayChef[i].getSize1(), this.arrayChef[i].getSize1());
        }

        //painting clients
        for (int i = 0; i < arrayClient.length; i++) {
            g.setColor(Color.blue);
            g.fillRect(this.arrayClient[i].getEjeX(), this.arrayClient[i].getEjeY()
                    + i + 70 * i + 1, this.arrayClient[i].getSize1(), this.arrayClient[i].getSize1());
        }

        //painting meals
        for (int i = 1; i <= table.getQuantity(); i++) {
            g.setColor(Color.white);
            g.fillOval(table.getEjeX()+30, table.getEjeY() +40 * i+10, 30, 30);

        }
    }

    @Override
    public void run() {
        while (stoped == false) {

            this.repaint();
            try {
                sleep(rate);
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
