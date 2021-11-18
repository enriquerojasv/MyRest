package myrest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rvenr
 */
public class Chef extends Thread {

    private int type;
    private int pace;
    private final Table table;
    private int ejeX;
    private int ejeY;
    private int sizeX;
    private int sizeY;
    private final int COOKING_TIME = 750;
    private final int CENTER_TABLE_X = 415;
    private final int CHEF_TABLE_X = 80;

    public Chef(int type, int pace, Table table, int ejeX, int ejeY, int sizeX,
            int sizeY) {
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

    public void cook() throws InterruptedException {
        sleep(this.COOKING_TIME);        
    }

    @Override
    public synchronized void run() {

        while (true) {
            try {
                this.cook();
                while (this.ejeX < CENTER_TABLE_X) {
                    this.ejeX++;
                    sleep(this.pace);
                }
                table.placeMeal(this);
                while (ejeX > CHEF_TABLE_X) {
                    this.ejeX--;
                    sleep(this.pace);
                }
                sleep(this.pace);
            } catch (InterruptedException ex) {
                Logger.getLogger(Chef.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
