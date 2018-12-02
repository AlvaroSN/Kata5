package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    
    private Connection connect() {
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;        
    }
    
    public void selectAll(){
        String sql = "select * from PEOPLE";
        try(Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" + 
                                   rs.getString("Nombre") + "\t" + 
                                   rs.getString("Apellidos") + "\t" + 
                                   rs.getString("Departamentos") + "\t");
            }            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
            
    }

}
