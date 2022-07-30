package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClsJdbc {
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "";
    String bd = "bd_elecciones";
    String url = "jdbc:mysql://localhost:3306/" + this.bd;
    
    public Connection conexion;
    
    
       public void CrearConexion(){        
    
        try {
         Class.forName(driver);
         this.conexion = DriverManager.getConnection(url,user,password);
         if(this.conexion != null){
             System.out.println("Conexion exitosa");
         }
    
    }catch(ClassNotFoundException | SQLException e){
            System.out.println("ocurrio un error al conectar" + e.getMessage());
    }
    }
}
