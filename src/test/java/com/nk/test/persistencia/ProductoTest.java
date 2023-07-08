package com.nk.test.persistencia;

import com.nk.models.bo.ProductoBO;
import com.nk.models.dao.ProductoDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.ProductoDTO;

public class ProductoTest {

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
        ProductoBO productoBO = new ProductoBO();
        ProductoDAO productoDAO = new ProductoDAO();
        productoBO.setProductoDAO(productoDAO);

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre("Cama");
        productoDTO.setDescripcion("Cama para perros color azul marino");
        productoDTO.setPrecio(35);
        productoDTO.setStock(10);
        productoDTO.setEstado(1);
        productoDTO.setFechaInserccion(null);
        productoDTO.setFechaActualizacion(null);
        productoDTO.setFechaEliminacion(null);
        productoDTO.setDescuento(0.1);

        System.out.println(productoBO.registrar(productoDTO));
    }

    private static void buscar() {
        ProductoBO productoBO = new ProductoBO();
        ProductoDAO productoDAO = new ProductoDAO();
        productoBO.setProductoDAO(productoDAO);

        System.out.println(productoBO.buscar(1));
    }

    private static void eliminar() {
        ProductoBO productoBO = new ProductoBO();
        ProductoDAO productoDAO = new ProductoDAO();
        productoBO.setProductoDAO(productoDAO);

        System.out.println(productoBO.eliminar(1));
        System.out.println(productoBO.buscar(1).getEstado());
    }

    private static void actualizar() {
        ProductoBO productoBO = new ProductoBO();
        ProductoDAO productoDAO = new ProductoDAO();
        productoBO.setProductoDAO(productoDAO);

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(1);
        productoDTO.setNombre("Algodon de Relleno");
        productoDTO.setDescripcion("Color Gris de Alta Calidad");
        productoDTO.setPrecio(10);
        productoDTO.setStock(5);
        productoDTO.setEstado(1);
        productoDTO.setFechaInserccion(null);
        productoDTO.setFechaActualizacion(null);
        productoDTO.setFechaEliminacion(null);
        productoDTO.setDescuento(0.05);

        System.out.println(productoBO.actualizar(productoDTO));
        System.out.println(productoBO.buscar(1));
    }

    private static void listarTodo() {
        ProductoBO productoBO = new ProductoBO();
        ProductoDAO productoDAO = new ProductoDAO();
        productoBO.setProductoDAO(productoDAO);
        productoBO.listar().forEach(System.out::println);
    }

}
