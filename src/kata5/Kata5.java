package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static kata5.CrearTabla.createNewTable;

public class Kata5 {
    public static void main(String[] args) {
        /*
        connect();
        SelectApp app = new SelectApp();
        app.selectAll();
        */
        createNewTable();
    }
    
    private static void connect(){
        Connection conn = null;
        try{
            String url = "jdbc:sqlite:Kata5.db";
            conn = (Connection) DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } 
    }
}
