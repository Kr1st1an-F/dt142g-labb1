import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("Laboration1");
        JButton button1 = new JButton("Press!");
        Panel p = new Panel();

        FileReader f = new FileReader("src/chat.txt");


        p.setLayout(new BorderLayout());
        p.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        frame.getContentPane().add(BorderLayout.EAST, p);
        frame.setVisible(true);
    }
}