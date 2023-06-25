package com.nk.models.dao;

import com.nk.models.dto.ProductoDTO;
import com.nk.models.idao.IProductoDAO;
import java.util.List;

public class ProductoDAO implements IProductoDAO<ProductoDTO, Integer> {

    @Override
    public boolean create(ProductoDTO t) {
        return false;
    }

    @Override
    public ProductoDTO read(Integer key) {
        return null;
    }

    @Override
    public List<ProductoDTO> readAll() {
        return null;
    }

    @Override
    public boolean update(ProductoDTO t) {
        return false;
    }

    @Override
    public boolean delete(Integer key) {
        return false;
    }

}
