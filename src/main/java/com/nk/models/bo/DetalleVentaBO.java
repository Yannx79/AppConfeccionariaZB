package com.nk.models.bo;

import com.nk.models.dao.DetalleVentaDAO;
import com.nk.models.dto.DetalleVentaDTO;
import java.util.List;


public class DetalleVentaBO{

    private DetalleVentaDAO detalleventaDAO;
    
    public boolean registrar(DetalleVentaDTO t) {
        return detalleventaDAO.create(t);
    }

    public DetalleVentaDTO buscar(int key,int key2) {
        return detalleventaDAO.read(key, key2);
    }

    public List<DetalleVentaDTO> listar() {
        return detalleventaDAO.readAll();
    }

    public boolean actualizar(DetalleVentaDTO t) {
        return detalleventaDAO.update(t);
    }

    public boolean eliminar(int key,int key2) {
        return detalleventaDAO.delete(key, key2);
    }


}
