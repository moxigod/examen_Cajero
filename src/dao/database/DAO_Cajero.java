/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.database;

import configuracion.basedatos;
import dao.interfac.CRUD;
import entidad.Cajero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class DAO_Cajero implements CRUD<Cajero>{

    @Override
    public int agregar(Cajero c) {
        int id = 0;
        basedatos bd = new basedatos();
        
        
        try {
            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                
                sql.append("INSERT INTO tbl_depositos")
                        .append(" (cliente, ahorro , credito, vencimiento) ")
                        .append(" VALUES (?,?,?,?)");
                PreparedStatement st = bd.getConn().prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                st.setString(1, c.getCliente());
                st.setDouble(2, c.getAhorro());
                st.setInt(3, c.getCredito());
                st.setString(4, c.getVencimiento());
                
                
                
                
                if (st.executeUpdate() == 1) {
                    ResultSet keys = st.getGeneratedKeys();
                    if(keys.next()){
                        id = keys.getInt(1);
                        
                    }
                    
                }                
               
            }
        } catch (Exception e) {
            System.out.println("[Error]"+e.getMessage());
            e.printStackTrace();
        }finally{
            
            bd.cerrarConexion();
        }
        
        
        return id;
    }

    @Override
    public int editar(Cajero c) {
        int xd = 0;
        basedatos bd = new basedatos();
        
        
        try {
            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                
                sql.append("UPDATE tbl_deposito SET ")
                        .append(" cliente = ?, ahorro = ?, credito = ?, vencimiento = ? ")
                        .append(" WHERE id = ? ");
                PreparedStatement st = bd.getConn().prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                st.setString(1, c.getCliente());
                st.setDouble(2, c.getAhorro());
                st.setInt(3, c.getCredito());
                st.setString(4, c.getVencimiento());
                
                if (st.executeUpdate() == 1) {
                    xd = 1;
                    
                }                
               
            }
        } catch (Exception e) {
            
        }finally{
            
            bd.cerrarConexion();
        }
        
        
        return xd; 
    }

    @Override
    public int eliminar(int id) {
       
        int respuesta = 0;
        basedatos bd = new basedatos();
        
        
        try {
            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                
                sql.append("DELETE FROM tbl_deposito ")
                        .append(" WHERE id = ? ");
                PreparedStatement st = bd.getConn().prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                st.setInt(1, id);
                
                if (st.executeUpdate() == 1) {
                    respuesta = 1;
                    
                }                
               
            }
        } catch (Exception e) {
            
        }finally{
            
            bd.cerrarConexion();
        }
        
        
        return respuesta;  
    }

    @Override
    public List<Cajero> obtenerTodo() {
        
        basedatos bd = new basedatos();
        List <Cajero> cajero =  new ArrayList();
        try {
            if (bd.getConn() != null) {
                StringBuilder _sql = new StringBuilder();
                _sql.append("SELECT * FROM tbl_depositos;");
                
                
                PreparedStatement st = bd.getConn()
                        .prepareStatement(_sql.toString());
                ResultSet rs = st.executeQuery();
                
                while (rs.next()) {     
                    Cajero c = new Cajero();
                    c.setId(rs.getInt("id"));
                    c.setCliente(rs.getString("cliente"));
                    c.setAhorro(rs.getDouble("ahorro"));
                    c.setCredito(rs.getInt("credito"));
                    c.setVencimiento(rs.getString("vencimiento"));
                    
                    
                    cajero.add(c);
   
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            bd.cerrarConexion();
        }
        
        return cajero;
    }

    @Override
    public List<Cajero> obtenerPor(String columna, String dato) {
       List<Cajero> cajero = new ArrayList();
        basedatos bd = new basedatos();
        
        try {
            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                
                sql.append("SELECT * FROM tbl_cajero")
                        .append(" WHERE ")
                        .append(columna).append(" LIKE ? ");
                PreparedStatement st = bd.getConn().prepareStatement(sql.toString());
                st.setString(1, "%"+dato+"%");
                
                ResultSet rs = st.executeQuery();
                
                while(rs.next()){
                    Cajero c = new Cajero();
                    c.setId(rs.getInt("id"));
                    c.setCliente(rs.getString("cliente"));
                    c.setAhorro(rs.getDouble("ahorro"));
                    c.setCredito(rs.getInt("credito"));
                    c.setVencimiento(rs.getString("vencimiento"));
                    
                    
                    cajero.add(c);
                }
                
            }
        } catch (Exception e) {
            
        }finally{
            bd.cerrarConexion();
        }
        
        return cajero;
    }

    @Override
    public Cajero obtenerId(int id) {
        Cajero c = new Cajero();
        basedatos bd = new basedatos();
        
        try {
            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                
                sql.append("SELECT * FROM tbl_cajero")
                        .append(" WHERE ")
                        .append(" id = ? ");
                PreparedStatement st = bd.getConn().prepareStatement(sql.toString());
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                
                if(rs.next()){
    
                    c.setId(rs.getInt("id"));
                    c.setCliente(rs.getString("cliente"));
                    c.setAhorro(rs.getDouble("ahorro"));
                    c.setCredito(rs.getInt("credito"));
                    c.setVencimiento(rs.getString("vencimiento"));
                    
                    
                   
                }
                
            }
        } catch (Exception e) {
            
        }finally{
            bd.cerrarConexion();
        }
        
        return c;
        
    }
    
}
