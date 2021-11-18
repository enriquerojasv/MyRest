package myrest;

/**
 *
 * @author rvenr
 */
public class Table extends Thread {

    private int quantity;
    private final int capacity;
    private int ejeX;
    private int ejeY;
    private int size1;
    private int size2;

    public Table(int quantity, int capacity, int ejeX, int ejeY, int size1, 
            int size2) {        
        this.quantity = quantity;
        this.capacity = capacity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //main method for chef to put the meal on the table
    public synchronized void placeMeal(Chef chef) throws InterruptedException {
        while (this.quantity >= this.capacity) {
            wait();
        }
        ++this.quantity;
        notify();        
    }

    //main method for client to take the meal of the table
    public synchronized void takeMeal(Client client) throws InterruptedException {
        while (this.quantity == 0) {
            wait();
        }
        //this sleep is for the meal to at least appear when client is waiting
        sleep(400);
        --this.quantity;
        notify();        
    } 
}
