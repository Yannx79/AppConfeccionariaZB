package com.nk.test.persistencia;

/* Importaciones para pruebas básicas
import com.nk.models.bo.InsumoBO;
import com.nk.models.dao.InsumoDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.InsumoDTO;*/

//Importaciones para prueba con frame
import com.nk.controllers.CAbastecer;
import com.nk.views.VAbastecer;

public class InsumoTest {

    public static void main(String[] args) {
//        registrar();
//        buscar();
//        eliminar();
//        actualizar();
//        listarTodo();
    }

/*  Pruebas básicas  
    private static void validarConexion() {
        Conexion conexion = Conexion.getConexion();
    }

    private static void registrar() {
        InsumoBO insumoBO = new InsumoBO();
        InsumoDAO insumoDAO = new InsumoDAO();
        insumoBO.setInsumoDAO(insumoDAO);

        InsumoDTO insumoDTO = new InsumoDTO();
        insumoDTO.setNombre("Cama");
        insumoDTO.setDescripcion("Cama para perros color azul marino");
        insumoDTO.setPrecio(35);
        insumoDTO.setStock(10);
        insumoDTO.setEstado(1);
        insumoDTO.setFechaInserccion(null);
        insumoDTO.setFechaActualizacion(null);
        insumoDTO.setFechaEliminacion(null);
        insumoDTO.setDescuento(0.1);

        System.out.println(insumoBO.registrar(insumoDTO));
    }

    private static void buscar() {
        InsumoBO insumoBO = new InsumoBO();
        InsumoDAO insumoDAO = new InsumoDAO();
        insumoBO.setInsumoDAO(insumoDAO);

        System.out.println(insumoBO.buscar(1));

    }

    private static void eliminar() {
        InsumoBO insumoBO = new InsumoBO();
        InsumoDAO insumoDAO = new InsumoDAO();
        insumoBO.setInsumoDAO(insumoDAO);

        System.out.println(insumoBO.eliminar(1));
        System.out.println(insumoBO.buscar(1).getEstado());
    }

    private static void actualizar() {
        InsumoBO insumoBO = new InsumoBO();
        InsumoDAO insumoDAO = new InsumoDAO();
        insumoBO.setInsumoDAO(insumoDAO);

        InsumoDTO insumoDTO = new InsumoDTO();
        insumoDTO.setIdInsumo(1);
        insumoDTO.setNombre("Algodon de Relleno");
        insumoDTO.setDescripcion("Color Gris de Alta Calidad");
        insumoDTO.setPrecio(10);
        insumoDTO.setStock(5);
        insumoDTO.setEstado(1);
        insumoDTO.setFechaInserccion(null);
        insumoDTO.setFechaActualizacion(null);
        insumoDTO.setFechaEliminacion(null);
        insumoDTO.setDescuento(0.05);

        System.out.println(insumoBO.actualizar(insumoDTO));
        System.out.println(insumoBO.buscar(1));
    }

    private static void listarTodo() {
        InsumoBO insumoBO = new InsumoBO();
        InsumoDAO insumoDAO = new InsumoDAO();
        insumoBO.setInsumoDAO(insumoDAO);
        insumoBO.listar().forEach(System.out::println);
    }*/

}
