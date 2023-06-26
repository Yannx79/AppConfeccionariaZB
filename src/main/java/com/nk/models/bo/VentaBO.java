package com.nk.models.bo;

import com.nk.models.dao.VentaDAO;
import com.nk.models.dto.VentaDTO;
import java.util.List;

public class VentaBO implements IBusinessObject<VentaDTO, Integer>{
    
    private VentaDAO ventaDAO;

    @Override
    public boolean registrar(VentaDTO t) {
        return ventaDAO.create(t);
    }

    @Override
    public VentaDTO buscar(Integer key) {
        return ventaDAO.read(key);
    }

    @Override
    public List<VentaDTO> listar() {
        return ventaDAO.readAll();
    }

    @Override
    public boolean actualizar(VentaDTO t) {
        return ventaDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return ventaDAO.delete(key);
    }

    public void setVentaDAO(VentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }
    
    

}
