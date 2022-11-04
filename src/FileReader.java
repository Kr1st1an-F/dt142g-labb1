import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> users = new ArrayList<String>();
    private ArrayList<String> messages = new ArrayList<String>();

    /**
     *
     * @param path
     * String containing the relative path to text file.
     * @throws FileNotFoundException
     * Throws FilexNotFoundException if it fails to open file.
     */
    FileReader(String path) throws FileNotFoundException {
        try {
            Scanner s = new Scanner(new File(path));
            String[] user = new String[3];
            int lineCounter = 1;
            while(s.hasNextLine()) {
                    String n1 = s.nextLine();
                    if(n1.matches("^M ([0-9]+) \\S+$")) {
                        user = n1.split(" ");
                        users.add(user[2]);
                    }else if(n1.matches("^([0-9]+) ([0-9]+|\\*) .*+$")){
                        messages.add(n1);
                    }else{
                        System.err.println("Wrong format on line " + lineCounter + " in file " + path);
                    }
                    lineCounter++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * @return
     * Returns a list of users including yourself.
     */
    public ArrayList<String> getUsers(){
        return users;
    }

    /**
     *
     * @param user
     * The user to find an associated private chat with.
     * @return
     * Returns the chat with the given user.
     */
    public String getPrivateChatWith(String user) {
        String chat = "";
        if(users.contains(user)) {
            int id = users.indexOf(user);
            for(String m : messages){
                if(m.charAt(0) == (char)(id + '0') && m.charAt(2) == '0'){
                    chat = chat + "<" + user + "> " + m.substring(4, m.length()) + "\n";
                }else if(m.charAt(2) == (char)(id + '0') && m.charAt(0) == '0'){
                    chat = chat + "<" + users.get(0) + "> " + m.substring(4, m.length()) + "\n";
                }
            }
            if(chat.isEmpty()) {
                chat = "Not Found";
            }
            return chat;
       }
       return null;
    }

    /**
     * @return
     * Returns the public chat.
     */
    public String getPublicChat(){
        String chat = "";
            for(String m : messages){
                if(m.charAt(2) == '*'){
                    chat = chat + "<" + users.get((int)(m.charAt(0) - '0')) + "> " + m.substring(4, m.length()) + "\n";
                }
            }
            return chat;
    }
}
