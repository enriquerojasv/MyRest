package myrest;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author rvenr
 */
public class MyRest {

    private static JFrame frame;
    private static final String TITLE = "My Restaurant";
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);

    public static void main(String[] args) {

        Table table1 = new Table(1, 0, 10, WIDTH / 2 - 25, 20, 60, HEIGHT - 80);

        table1.start();
        Chef chef1 = new Chef(1, 5, table1, 90, HEIGHT, 60, 60);
        Chef chef2 = new Chef(2, 20, table1, 90, HEIGHT / 3 + 5, 60, 60);
        Chef chef3 = new Chef(3, 10, table1, 90, HEIGHT / 3 + 5, 60, 60);

        chef1.start();
        //chef2.start();
        //chef3.start();

        Client client1 = new Client(1, 10, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client2 = new Client(2, 15, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client3 = new Client(3, 15, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client4 = new Client(4, 30, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client5 = new Client(5, 5, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client6 = new Client(6, 800, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client7 = new Client(7, 900, table1, 600, HEIGHT / 4 + 5, 60, 60);
        Client client8 = new Client(8, 1000, table1, 600, HEIGHT / 4 + 5, 60, 60);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        //client5.start();
        //client6.start();
        //client7.start();
        //client8.start();

        Chef[] arrayChef = {chef1, chef2, chef3};
        Client[] arrayClient = {client1, client2, client3, client4, client5,
            client6, client7, client8};

        frame = new JFrame(TITLE);
        frame.setPreferredSize(SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);

        Viewer viewer = new Viewer(SIZE, arrayChef, arrayClient, table1);
        viewer.setRate(50);

        frame.add(viewer.getCanvas());

        frame.pack();
        frame.setVisible(true);

        viewer.run();

    }

}
