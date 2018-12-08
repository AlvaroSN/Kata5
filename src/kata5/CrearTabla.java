package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    
    public static void createNewTable(){
        String url = "jdbc:sqlite:Kata5.db";
        String sql = "CREATE TABLE emails (\n"
                + " `id` integer primary key autoincrement,\n"
                + " `mail` text not null)";
        try(Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) { 
            stmt.execute(sql);
            System.out.println("Tabla creada con éxito");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
