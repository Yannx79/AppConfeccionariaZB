package com.nk.models.dao;

import com.nk.models.dto.InsumoDTO;
import com.nk.models.idao.IInsumoDAO;
import java.util.List;

public class InsumoDAO implements IInsumoDAO<InsumoDTO, Integer> {

    @Override
    public boolean create(InsumoDTO t) {
        return false;
    }

    @Override
    public InsumoDTO read(Integer key) {
        return null;
    }

    @Override
    public List<InsumoDTO> readAll() {
        return null;
    }

    @Override
    public boolean update(InsumoDTO t) {
        return false;
    }

    @Override
    public boolean delete(Integer key) {
        return false;
    }

}
