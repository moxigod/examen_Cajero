/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class basedatos {
    
    //Atributos
    private Connection conn = null;
    private String error = new String();
    private String _url = "jdbc:mysql://localhost:3306/bd_cajero?useSSL=false";
    private String _user = "root";
    private String _password = "amisa12345";
       
    
    
    public basedatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(_url, _user, _password);
            JOptionPane.showMessageDialog(null, "esperando..");
           
        } catch (Exception e) {
            error = e.getMessage();
        }
    }

    public  basedatos (String _url, String _user, String _password){
        this._url = _url;
        this._user = _user;
        this._password = _password;
         try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(_url, _user, _password);
            JOptionPane.showMessageDialog(null, "esperando..");
           
        } catch (Exception e) {
            error = e.getMessage();
        }
    }
        
     
    
    //Getters and setters
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    //Metodos propios de la clase
    
    public void cerrarConexion(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
