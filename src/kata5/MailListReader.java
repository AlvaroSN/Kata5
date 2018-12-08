package kata5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 public class MailListReader {
    public static List<String> read (String fileName) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> mailList = new ArrayList<>();
        String mail = new String();
        
        while((mail = br.readLine()) != null){
            if(mail.contains("@")) {
                mailList.add(mail.substring(mail.lastIndexOf("@")+1,mail.length()-1));
            }
        }
    return mailList;
    }
}