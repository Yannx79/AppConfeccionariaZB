
package com.nk.models.bo;

import com.nk.models.dao.UsuarioDAO;
import com.nk.models.dto.UsuarioDTO;
import java.util.List;

public class UsuarioBO IBusinessObject<UsuarioDTO, Integer>{

 private UsuarioDAO iusuarioDAO;
    
    @Override
    public boolean registrar(UsuarioDTO t) {
        return usuarioDAO.create(t);
    }

    @Override
    public UsuarioDTO buscar(Integer key) {
        return usuarioDAO.read(key);
    }

    @Override
    public List<UsuarioDTO> listar() {
        return usuarioDAO.readAll();
    }

    @Override
    public boolean actualizar(UsuarioDTO t) {
        return usuarioDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return usuarioDAO.delete(key);
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    
    
}