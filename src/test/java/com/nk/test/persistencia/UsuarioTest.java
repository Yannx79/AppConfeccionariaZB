package com.nk.test.persistencia;

import com.nk.models.bo.UsuarioBO;
import com.nk.models.dao.UsuarioDAO;
import com.nk.models.datasource.Conexion;
import com.nk.models.dto.UsuarioDTO;

public class UsuarioTest {

    public static void main(String[] args) {
//        registrar();
//        buscar(); // funciona
//        eliminar();
//        actualizar();
//        listarTodo(); // funciona
    }

    private static void validarConexion() {
        Conexion conexion = Conexion.getConexion();
    }

    private static void registrar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO.setUsuarioDAO(usuarioDAO);

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombres("Ara");
        usuarioDTO.setApPaterno("Enr");
        usuarioDTO.setApMaterno("Lei");
        usuarioDTO.setUsuario("AENRIQUEZ");
        usuarioDTO.setPass("A123");

        System.out.println(usuarioBO.registrar(usuarioDTO));
    }

    private static void buscar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO.setUsuarioDAO(usuarioDAO);

        System.out.println(usuarioBO.buscar(1));

    }

    private static void eliminar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO.setUsuarioDAO(usuarioDAO);

        System.out.println(usuarioBO.eliminar(1));
        System.out.println(usuarioBO.buscar(1));
    }

    private static void actualizar() {
        UsuarioBO usuarioBO = new UsuarioBO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO.setUsuarioDAO(usuarioDAO);

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(1);
        usuarioDTO.setNombres("Arace");
        usuarioDTO.setApPaterno("Enrique");
        usuarioDTO.setApMaterno("Leiva");
        usuarioDTO.setUsuario("AENRIQUEZ");
        usuarioDTO.setPass("A123");

        System.out.println(usuarioBO.actualizar(usuarioDTO));
        System.out.println(usuarioBO.buscar(1));
    }

    private static void listarTodo() {
        UsuarioBO usuarioBO = new UsuarioBO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO.setUsuarioDAO(usuarioDAO);
        usuarioBO.listar().forEach(System.out::println);
    }
}
