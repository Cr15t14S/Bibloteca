package modelo.dao;


import modelo.dto.EmpleadoDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudiante
 */
public class EmpleadoDAO {
    public EmpleadoDTO validaSesion(EmpleadoDTO item ){
        EmpleadoDTO prueba = new EmpleadoDTO("15","Sandra","sandra@gmail.com","1234");
        if(item.getCorreo().equals(prueba.getCorreo()) && item.getClave().equalsIgnoreCase(prueba.getClave())){
            return prueba;
        }else{
            return null;
        }
        
        
    }
}
