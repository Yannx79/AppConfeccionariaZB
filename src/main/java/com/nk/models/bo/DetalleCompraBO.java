package com.nk.models.bo;

import com.nk.models.dao.DetalleCompraDAO;
import com.nk.models.dto.DetalleCompraDTO;
import java.util.List;


public class DetalleCompraBO {
    
    private DetalleCompraDAO detallecompraDAO;
    
    public boolean registrar(DetalleCompraDTO t) {
        return detallecompraDAO.create(t);
    }

    public DetalleCompraDTO buscar(int key,int key2) {
        return detallecompraDAO.read(key, key2);
    }

    public List<DetalleCompraDTO> listar() {
        return detallecompraDAO.readAll();
    }

    public boolean actualizar(DetalleCompraDTO t) {
        return detallecompraDAO.update(t);
    }

    public boolean eliminar(int key,int key2) {
        return detallecompraDAO.delete(key, key2);
    }

    public void setDetalleCompraDAO(DetalleCompraDAO detallecompraDAO) {
        this.detallecompraDAO = detallecompraDAO;
    }

}
