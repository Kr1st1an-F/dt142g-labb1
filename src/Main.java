import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Laboration1");
        JButton button1 = new JButton("Press!");
        Menu menu1 = new Menu();
        Panel p = new Panel();

        p.setLayout(new BorderLayout());
        p.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        frame.getContentPane().add(BorderLayout.EAST, p);
        frame.setJMenuBar(menu1.menuBar);
        frame.setVisible(true);
    }
}