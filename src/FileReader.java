import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> users = new ArrayList<String>();
    private ArrayList<String> messages = new ArrayList<String>();
    FileReader(String path) throws FileNotFoundException {
        try {
            Scanner s = new Scanner(new File(path));
            while(s.hasNextLine()) {
                String n1 = s.next();
                if(n1.contains("M")) {
                    String index = s.next();
                    String user = s.nextLine();
                    users.add(user.substring(1, user.length()));
                }else{
                    messages.add(n1 + s.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
    public ArrayList<String> getUsers(){
        return users;
    }

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
