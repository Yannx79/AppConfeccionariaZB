package com.nk.models.bo;

import java.util.List;

public interface IBusinessObject<T, K> {

    public abstract boolean registrar(T t);

    public abstract T buscar(K key);

    public abstract List<T> listar();

    public abstract boolean actualizar(T t);

    public abstract boolean eliminar(K key);
    
}
