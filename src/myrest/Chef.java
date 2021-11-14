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
    private Table table;
    private int ejeX;
    private int ejeY;
    private int size1;
    private int size2;

    public Chef(int type, int pace, Table table, int ejeX, int ejeY, int size1, int size2) {
        this.type = type;
        this.pace = pace;
        this.table = table;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.size1 = size1;
        this.size2 = size2;
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

    public int getSize1() {
        return size1;
    }

    public void setSize1(int size1) {
        this.size1 = size1;
    }

    public int getSize2() {
        return size2;
    }

    public void setSize2(int size2) {
        this.size2 = size2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public void cook() throws InterruptedException {
        sleep(this.pace);
        System.out.println("Chef is cooking");
    }

    @Override
    public synchronized void run() {

        while (true) {
            try {
                this.cook();
                while (this.ejeX < 420) {
                    this.ejeX++;
                    sleep(this.pace);
                }
                table.placeMeal(this);
                while (ejeX > 60) {
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
