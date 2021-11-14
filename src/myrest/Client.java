package myrest;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rvenr
 */
public class Client extends Thread{
    
    private int type;
    private int pace;
    private Table table;
    private int ejeX;
    private int ejeY;
    private int size1;
    private int size2;

    public Client(int type, int pace, Table table, int ejeX, int ejeY, int size1, int size2) {
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
    
    public void eat() throws InterruptedException{               
        sleep(this.pace);
        System.out.println("Client is eating");
    }
    
    
    @Override
    public synchronized void run() {

        while (true) {

            try {                       
                while(ejeX>560){
                    this.ejeX--;
                    sleep(this.pace);
                }
                
                table.takeMeal(this);
                while(ejeX<870){
                    this.ejeX++;
                    sleep(this.pace);
                }
                this.eat();
                sleep(this.pace);       
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
