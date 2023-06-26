package com.nk.test.persistencia;

import com.nk.models.bo.VentaBO;
import com.nk.models.dao.VentaDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.VentaDTO;

public class VentaTest {

    public static void main(String[] args) {
//registrar();
//buscar();
//eliminar();
//actualizar();
//listarTodo();        
    }
    
    private static void validarConexion() {
        Conexion conexion = Conexion.getConexion();
    }

    private static void registrar() {
        VentaBO ventaBO = new VentaBO();
        VentaDAO ventaDAO = new VentaDAO();
        ventaBO.setVentaDAO(ventaDAO);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId_usuario(1);
        ventaDTO.setId_cliente(1);
        ventaDTO.setTotal(333.333);
        ventaDTO.setImpuesto(0.18);
        System.out.println(ventaBO.registrar(ventaDTO));
    }

    private static void buscar() {
        VentaBO ventaBO = new VentaBO();
        VentaDAO ventaDAO = new VentaDAO();
        ventaBO.setVentaDAO(ventaDAO);

        System.out.println(ventaBO.buscar(2));

    }

    private static void eliminar() {
        VentaBO ventaBO = new VentaBO();
        VentaDAO ventaDAO = new VentaDAO();
        ventaBO.setVentaDAO(ventaDAO);

        System.out.println(ventaBO.eliminar(2));
        System.out.println(ventaBO.buscar(2).getEstado());
    }

    private static void actualizar() {
        VentaBO ventaBO = new VentaBO();
        VentaDAO ventaDAO = new VentaDAO();
        ventaBO.setVentaDAO(ventaDAO);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId_venta(1);
        ventaDTO.setId_usuario(1);
        ventaDTO.setId_cliente(1);
        ventaDTO.setTotal(322.322);
        ventaDTO.setImpuesto(0.18);
        ventaDTO.setEstado(1);

        System.out.println(ventaBO.actualizar(ventaDTO));
        System.out.println(ventaBO.buscar(1));
    }

  private static void listarTodo() {
        VentaBO ventaBO = new VentaBO();
        VentaDAO ventaDAO = new VentaDAO();
        ventaBO.setVentaDAO(ventaDAO);
        ventaBO.listar().forEach(System.out::println);
    }

}
