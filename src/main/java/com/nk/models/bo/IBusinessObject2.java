package com.nk.models.bo;

import java.util.List;

public interface IBusinessObject2<T, K> {

    public abstract boolean registrar(T t);

    public abstract T buscar(K key, K key2);

    public abstract List<T> listar();

    public abstract boolean actualizar(T t);

    public abstract boolean eliminar(K key, K key2);
    
}
