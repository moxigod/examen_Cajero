/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfac;

import java.util.List;

/**
 *
 * @author usuario
 */
public interface CRUD <T> {
    public int agregar(T o);
    public int editar(T o);
    public int eliminar(int id);
    
    public List<T> obtenerTodo();
    public List<T> obtenerPor(String columna, String dato);  
    public T obtenerId(int id);
}
