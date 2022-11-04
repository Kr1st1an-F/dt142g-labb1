import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> users = new ArrayList<String>();
    private Map<String, Integer> userMap = new HashMap<String, Integer>();
    private ArrayList<String> messages;
    FileReader(String path) throws FileNotFoundException {
        try {
            Scanner s = new Scanner(new File(path));
            while(s.hasNextLine()) {
                String n1 = s.next();
                if(n1.contains("M")) {
                    String index = s.next();
                    String user = s.nextLine();
                    users.add(user);
                    userMap.put(user, Integer.parseInt(index));
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
       if(userMap.containsKey(user)) {
            Integer id = userMap.get(user);
            for(String m : messages){
            }
       }
       return null;
    }
    public String getPublicChat(){
        return ":)";
    }
}
