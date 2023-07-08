package com.nk.models.bo;

import com.nk.models.dao.CompraDAO;
import com.nk.models.dto.CompraDTO;
import java.util.List;

public class CompraBO implements IBusinessObject<CompraDTO, Integer> {

    private CompraDAO compraDAO;

    public CompraBO() {
        this.compraDAO = new CompraDAO(); // Inicializa el objeto compraDAO
    }

    @Override
    public boolean registrar(CompraDTO t) {
        return compraDAO.create(t);
    }

    @Override
    public CompraDTO buscar(Integer key) {
        return compraDAO.read(key);
    }

    @Override
    public List<CompraDTO> listar() {
        return compraDAO.readAll();
    }

    @Override
    public boolean actualizar(CompraDTO t) {
        return compraDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return compraDAO.delete(key);
    }

    public void setCompraDAO(CompraDAO compraDAO) {
        this.compraDAO = compraDAO;
    }
}