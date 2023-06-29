package com.nk.test.persistencia;
import com.nk.models.bo.DetalleCompraBO;
import com.nk.models.dao.DetalleCompraDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.DetalleCompraDTO;

public class DetalleCompraTest {

    public static void main(String[] args) {
//      registrar();
//     buscar();
//     eliminar();
//     actualizar();
//     listarTodo();        
    }
        private static void validarConexion() {
        Conexion conexion = Conexion.getConexion();
    }         
        private static void registrar() {
        DetalleCompraBO detallecompraBO = new DetalleCompraBO();
        DetalleCompraDAO detallecompraDAO = new DetalleCompraDAO();
        detallecompraBO.setDetalleCompraDAO(detallecompraDAO);

        DetalleCompraDTO detallecompraDTO = new DetalleCompraDTO();
        detallecompraDTO.setId_insumo(1);
        detallecompraDTO.setId_compra(1);
        detallecompraDTO.setSubtotal(50);
        detallecompraDTO.setCantidad(10);
        //detallecompraDTO.setEstado(0);
        System.out.println(detallecompraBO.registrar(detallecompraDTO));
    }
        
        private static void buscar() {
        DetalleCompraBO detalleCompraBO = new DetalleCompraBO();
        DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
        detalleCompraBO.setDetalleCompraDAO(detalleCompraDAO);

        System.out.println(detalleCompraBO.buscar(1,1));
    }
        private static void actualizar() {
        DetalleCompraBO detalleCompraBO = new DetalleCompraBO();
        DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
        detalleCompraBO.setDetalleCompraDAO(detalleCompraDAO);

        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
        detalleCompraDTO.setId_insumo(2);
        detalleCompraDTO.setId_compra(1);
        detalleCompraDTO.setSubtotal(1);
        detalleCompraDTO.setCantidad(10);
        detalleCompraDTO.setEstado(1);

        System.out.println(detalleCompraBO.actualizar(detalleCompraDTO));
        System.out.println(detalleCompraBO.buscar(2,1));
    }
        private static void listarTodo() {
        DetalleCompraBO detalleCompraBO = new DetalleCompraBO();
        DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
        detalleCompraBO.setDetalleCompraDAO(detalleCompraDAO);
        detalleCompraBO.listar().forEach(System.out::println);
    }    
}
