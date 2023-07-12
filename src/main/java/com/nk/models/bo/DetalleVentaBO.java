package com.nk.models.bo;

import com.nk.models.dao.DetalleVentaDAO;
import com.nk.models.dto.DetalleVentaDTO;
import java.util.List;

public class DetalleVentaBO implements IBusinessObject2<DetalleVentaDTO, Integer> {

    private DetalleVentaDAO detalleventaDAO;

    public boolean registrar(DetalleVentaDTO t) {
        return detalleventaDAO.create(t);
    }

    public DetalleVentaDTO buscar(Integer key, Integer key2) {
        return detalleventaDAO.read(key, key2);
    }

    public List<DetalleVentaDTO> listar() {
        return detalleventaDAO.readAll();
    }

    public boolean actualizar(DetalleVentaDTO t) {
        return detalleventaDAO.update(t);
    }

    public boolean eliminar(Integer key, Integer key2) {
        return detalleventaDAO.delete(key, key2);
    }

    public void setDetalleVentaDAO(DetalleVentaDAO detalleventaDAO) {
        this.detalleventaDAO = detalleventaDAO;
    }

}
