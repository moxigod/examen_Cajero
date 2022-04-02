/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import dao.database.DAO_Cajero;
import entidad.Cajero;
import java.util.List;

/**
 *
 * @author usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Jesus Ramon Hernandez Tirado 00000228861
        DAO_Cajero caja = new DAO_Cajero();
        List<Cajero> cajero = caja.obtenerTodo();
        for(Cajero c: cajero){
            System.out.println(c.toString());
        }
        
        System.out.println("elpepe xd");
        
    }
    
}
