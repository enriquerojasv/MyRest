package myrest;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rvenr
 */
public class Client extends Thread {

    private int type;
    private int pace;
    private final Table table;
    private int ejeX;
    private int ejeY;
    private int sizeX;
    private int sizeY;
    private final int EATING_TIME = 2000;
    private final int CENTER_TABLE_X = 565;
    private final int CLIENT_TABLE_X = 840;

    public Client(int type, int pace, Table table, int ejeX, int ejeY,
            int sizeX, int sizeY) {
        this.type = type;
        this.pace = pace;
        this.table = table;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getEjeX() {
        return ejeX;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCENTER_TABLE_X() {
        return CENTER_TABLE_X;
    }

    public int getCLIENT_TABLE_X() {
        return CLIENT_TABLE_X;
    }

    public void eat() throws InterruptedException {
        sleep(this.EATING_TIME);
    }

    @Override
    public synchronized void run() {

        while (true) {
            try {
                while (ejeX > CENTER_TABLE_X) {
                    this.ejeX--;
                    sleep(this.pace);
                }
                table.takeMeal(this);
                while (ejeX < CLIENT_TABLE_X) {
                    this.ejeX++;
                    sleep(this.pace);
                }
                this.eat();

            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
