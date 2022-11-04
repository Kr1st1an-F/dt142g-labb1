import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Laboration1");
        JPanel p = new ChatPanel();
        p.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        frame.getContentPane().add(BorderLayout.EAST, p);
        frame.setVisible(true);
    }
}