import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Laboration1");
        ChatPanel p = new ChatPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        frame.add(p.getPanel());
        frame.setVisible(true);
        frame.pack();
    }
}