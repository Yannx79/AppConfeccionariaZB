
package com.nk.models.bo;

import com.nk.models.dao.ProveedorDAO;
import com.nk.models.dto.ProveedorDTO;
import java.util.List;

public class ProveedorBO IBusinessObject<ProveedorDTO, Integer>{
 private ProveedorDAO proveedorDAO;
    
    @Override
    public boolean registrar(ProveedorDTO t) {
        return proveedorDAO.create(t);
    }

    @Override
    public ProveedorDTO buscar(Integer key) {
        return proveedorDAO.read(key);
    }

    @Override
    public List<ProveedorDTO> listar() {
        return proveedorDAO.readAll();
    }

    @Override
    public boolean actualizar(ProveedorDTO t) {
        return proveedorDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return proveedorDAO.delete(key);
    }

    public void setProveedorDAO(ProveedorDAO proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }
    
    
    
}