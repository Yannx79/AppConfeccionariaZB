package com.nk.test.persistencia;
import com.nk.models.bo.CompraBO;
import com.nk.models.dao.CompraDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.CompraDTO;

public class CompraTest {
    
    public static void main(String[] args) {
//     registrar();
//     buscar();
//     eliminar();
//     actualizar();
//     listarTodo();
    }
    private static void validarConexion() {
        Conexion conexion = Conexion.getConexion();
    }
    
        private static void registrar() {
        CompraBO compraBO = new CompraBO();
        CompraDAO compraDAO = new CompraDAO();
        compraBO.setCompraDAO(compraDAO);

        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setId_proveedor(1);
        compraDTO.setId_usuario(1);
        compraDTO.setTotal(35);
        compraDTO.setFecha(null);
        compraDTO.setImpuesto(1);
        compraDTO.setEstado(1);
        System.out.println(compraBO.registrar(compraDTO));
    }
        
            private static void buscar() {
        CompraBO compraBO = new CompraBO();
        CompraDAO compraDAO = new CompraDAO();
        compraBO.setCompraDAO(compraDAO);

        System.out.println(compraBO.buscar(1));

    }
            private static void eliminar() {
        CompraBO compraBO = new CompraBO();
        CompraDAO compraDAO = new CompraDAO();
        compraBO.setCompraDAO(compraDAO);

        System.out.println(compraBO.eliminar(1));
        System.out.println(compraBO.buscar(1).getEstado());
    }

        private static void actualizar() {
        CompraBO compraBO = new CompraBO();
        CompraDAO compraDAO = new CompraDAO();
        compraBO.setCompraDAO(compraDAO);
        
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setId_compra(1);
        compraDTO.setId_proveedor(1);
        compraDTO.setId_usuario(1);
        compraDTO.setTotal(60);
        compraDTO.setFecha(null);
        compraDTO.setImpuesto(1);
        compraDTO.setEstado(1);

        System.out.println(compraBO.actualizar(compraDTO));
        System.out.println(compraBO.buscar(1));
    }
        
        private static void listarTodo() {
        CompraBO campoBO = new CompraBO();
        CompraDAO campoDAO = new CompraDAO();
        campoBO.setCompraDAO(campoDAO);
        campoBO.listar().forEach(System.out::println);
    }  
}
