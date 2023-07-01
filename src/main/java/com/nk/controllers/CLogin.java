package com.nk.controllers;

import com.nk.models.bo.UsuarioBO;
import com.nk.models.dao.UsuarioDAO;
import com.nk.models.dto.ClienteDTO;
import com.nk.models.dto.UsuarioDTO;
import com.nk.models.utilities.Encriptar;
import com.nk.views.VLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CLogin extends IController implements ActionListener {

    private UsuarioBO usuarioBO;
    private UsuarioDAO usuarioDAO;
    private List<UsuarioDTO> list;
    private VLogin vLogin;

    public CLogin(VLogin vLogin) {
        this.vLogin = vLogin;
        super.builder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vLogin.btnLogin) {
            this.loguear();
        }
    }

    private void loguear() {
        String email = this.vLogin.txtEmail.getText();
        String password = Encriptar.toMD5(String.valueOf(this.vLogin.txtPassword.getPassword()));
        boolean estaLogueado = false;
        for (UsuarioDTO c : list) {
            if (c.getUsuario().equals(email) && c.getPass().equals(password)) {
                estaLogueado = true;
                break;
            }
        }
        if (estaLogueado) {
            this.vLogin.dispose();
        } else {
            this.vLogin.txtEmail.setText("");
            this.vLogin.txtPassword.setText("");
        }
    }

    @Override
    public void instanciar() {
        this.usuarioBO = new UsuarioBO();
        this.usuarioDAO = new UsuarioDAO();
        this.usuarioBO.setUsuarioDAO(usuarioDAO);
        this.list = usuarioBO.listar();
    }

    @Override
    public void addAllListener() {
        this.vLogin.btnLogin.addActionListener(this);
    }

    @Override
    public void presentar() {
        this.vLogin.setVisible(true);
    }
}
