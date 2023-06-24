package com.nk.models.bo;

import com.nk.models.dao.InsumoDAO;
import com.nk.models.dto.InsumoDTO;
import java.util.List;

public class InsumoBO implements IBusinessObject<InsumoDTO, Integer> {

    private InsumoDAO insumoDAO;
    
    @Override
    public boolean registrar(InsumoDTO t) {
        return insumoDAO.create(t);
    }

    @Override
    public InsumoDTO buscar(Integer key) {
        return insumoDAO.read(key);
    }

    @Override
    public List<InsumoDTO> listar() {
        return insumoDAO.readAll();
    }

    @Override
    public boolean actualizar(InsumoDTO t) {
        return insumoDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return insumoDAO.delete(key);
    }

    public void setInsumoDAO(InsumoDAO insumoDAO) {
        this.insumoDAO = insumoDAO;
    }
    
    
    
}
