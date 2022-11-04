import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("Laboration1");
        JButton button1 = new JButton("Press!");
        Menu menu1 = new Menu();
        Panel p = new Panel();

        //Demo of using the FileReader class
        //==================================================================
        FileReader fileReader = new FileReader("src/chat.txt"); //Constructing object
        ArrayList<String> users = fileReader.getUsers(); //Returns list of users
        fileReader.getPrivateChatWith(users.get(2)); //Gets private chat with user in the list at index 2 as String
        fileReader.getPublicChat(); //Gets the public chat as String
        //==================================================================

        p.setLayout(new BorderLayout());
        p.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        frame.getContentPane().add(BorderLayout.EAST, p);
        frame.setJMenuBar(menu1.menuBar);
        frame.setVisible(true);
    }
}