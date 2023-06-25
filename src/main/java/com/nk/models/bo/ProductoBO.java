package com.nk.models.bo;

import com.nk.models.dao.ProductoDAO;
import com.nk.models.dto.ProductoDTO;
import java.util.List;

public class ProductoBO implements IBusinessObject<ProductoDTO, Integer> {

    private ProductoDAO productoDAO;
    
    @Override
    public boolean registrar(ProductoDTO t) {
        return productoDAO.create(t);
    }

    @Override
    public ProductoDTO buscar(Integer key) {
        return productoDAO.read(key);
    }

    @Override
    public List<ProductoDTO> listar() {
        return productoDAO.readAll();
    }

    @Override
    public boolean actualizar(ProductoDTO t) {
        return productoDAO.update(t);
    }

    @Override
    public boolean eliminar(Integer key) {
        return productoDAO.delete(key);
    }

    public void setInsumoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
    
}
