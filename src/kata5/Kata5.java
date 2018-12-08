package kata5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static kata5.CrearTabla.createNewTable;

public class Kata5 {
    static Connection conn;
    private static Connection connect(){
        conn = null;
        try{
            String url = "jdbc:sqlite:Kata5.db";
            conn = (Connection) DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(List<String> mailList){
        String sql = "INSERT INTO emails(mail) VALUES(?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (String mail : mailList) {
                pstmt.setString(1, mail);
                pstmt.executeUpdate();             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
    public static void main(String[] args) throws IOException, SQLException {
        //createNewTable();
        String ruta = "/Users/ALVARO/Desktop/Uni/IS2/kata5/email.txt";
        List<String> mailList = MailListReader.read(ruta);
        Kata5 idt = new Kata5();
        idt.insert(mailList);  
    }
}    

