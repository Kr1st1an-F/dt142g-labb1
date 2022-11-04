import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    // MENUBAR AND MENU
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu show = new JMenu("Show");
    JMenuItem item1 = new JMenuItem("Exit");
    JCheckBox item2 = new JCheckBox("Private chat");
    JCheckBox item3 = new JCheckBox("Public chat");

    // CONSTRUCTOR
    Menu() {
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        file.add(item1);
        show.add(item2);
        show.add(item3);
        menuBar.add(file);
        menuBar.add(show);
        item2.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == item2){
            item3.setSelected(false);
            item2.setSelected(true);
        }
        if(e.getSource() == item3){
            item2.setSelected(false);
            item3.setSelected(true);
        }
    }
}
