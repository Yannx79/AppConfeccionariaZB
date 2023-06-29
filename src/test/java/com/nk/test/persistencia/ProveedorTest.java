
package com.nk.test.persistencia;

import com.nk.models.bo.ProveedorBO;
import com.nk.models.dao.ProveedorDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.ProveedorDTO;

public class ProveedorTest {
   public static void main(String[] args) {
//        registrar();
//        buscar();
//        eliminar();
//        actualizar();
//        listarTodo();
    }
  private static void validarConexion() {
        Conexion conexion = Conexion.getConexion();
    }   
  
  private static void registrar() {
        ProveedorBO proveedorBO = new ProveedorBO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO.setProveedorDAO(proveedorDAO);

        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setNombres("Mar");
        proveedorDTO.setApPaterno("Fer");
        proveedorDTO.setApMaterno("Cast");
        proveedorDTO.setRuc("1432121");
        proveedorDTO.setDni("1234567");
        proveedorDTO.setTelefono("192939");
        proveedorDTO.setfInsercion(null);
        proveedorDTO.setfActualizacion(null);
        proveedorDTO.setfEliminacion(null);
        proveedorDTO.setEstado(1);

        System.out.println(proveedorBO.registrar(proveedorDTO));
    }
  private static void buscar() {
        ProveedorBO proveedorBO = new ProveedorBO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO.setProveedorDAO(proveedorDAO);
        System.out.println(proveedorBO.buscar(1));
    }
 private static void eliminar() {
        ProveedorBO proveedorBO = new ProveedorBO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO.setProveedorDAO(proveedorDAO);

        System.out.println(proveedorBO.eliminar(1));
        System.out.println(proveedorBO.buscar(1).getEstado());
    } 
  private static void actualizar() {
        ProveedorBO proveedorBO = new ProveedorBO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO.setProveedorDAO(proveedorDAO);

        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setIdProveedor(1);
        proveedorDTO.setNombres("Maria");
        proveedorDTO.setApPaterno("Fernanda");
        proveedorDTO.setApMaterno("Castillo");
        proveedorDTO.setRuc("1222");
        proveedorDTO.setDni("13333");
        proveedorDTO.setTelefono("192939");
        proveedorDTO.setfInsercion(null);
        proveedorDTO.setfActualizacion(null);
        proveedorDTO.setfEliminacion(null);
        proveedorDTO.setEstado(1);
        
        
        System.out.println(proveedorBO.actualizar(proveedorDTO));
        System.out.println(proveedorBO.buscar(1));
    }
    private static void listarTodo() {
        ProveedorBO proveedorBO = new ProveedorBO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO.setProveedorDAO(proveedorDAO);
        proveedorBO.listar().forEach(System.out::println);
    }
}
