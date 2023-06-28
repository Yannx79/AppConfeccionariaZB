
package com.nk.test.persistencia;

import com.nk.models.bo.InsumoBO;
import com.nk.models.dao.InsumoDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.InsumoDTO;

public class ClienteTest {
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
        ClienteBO clienteBO = new ClienteBO();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteBO.setClienteDAO(clienteDAO);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombres("Ara");
        clienteDTO.setApPaterno("Enr");
        clienteDTO.setApMaterno("Lei");
        clienteDTO.setDni("1234");
        clienteDTO.setTelefono("1234");
        clienteDTO.setfInsercion(null);
        clienteDTO.setfActualizacion(null);
        clienteDTO.setfEliminacion(null);
        clienteDTO.setEstado(1);

        System.out.println(clienteBO.registrar(clienteDTO));
    }
 private static void buscar() {
        ClienteBO clienteBO = new ClienteBO();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteBO.setClienteDAO(clienteDAO);

        System.out.println(clienteBO.buscar(1));

    }
  private static void eliminar() {
        ClienteBO clienteBO = new ClienteBO();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteBO.setClienteDAO(clienteDAO);

        System.out.println(clienteBO.eliminar(1));
        System.out.println(clienteBO.buscar(1).getEstado());
    }
  
  private static void actualizar() {
        ClienteBO clienteBO = new ClienteBO();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteBO.setClienteDAO(clienteDAO);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(1);
        clienteDTO.setNombres("Arace");
        clienteDTO.setApPaterno("Enriq");
        clienteDTO.setApMaterno("Leiv");
        clienteDTO.setDni("12345");
        clienteDTO.setTelefono("12345");
        clienteDTO.setfInsercion(null);
        clienteDTO.setfActualizacion(null);
        clienteDTO.setfEliminacion(null);
        clienteDTO.setEstado(1);

        System.out.println(clienteBO.actualizar(clienteDTO));
        System.out.println(clienteBO.buscar(1));
    }
   private static void listarTodo() {
        ClienteBO clienteBO = new ClienteBO();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteBO.setClienteDAO(insumoDAO);
        clienteBO.listar().forEach(System.out::println);
    }
  
}
