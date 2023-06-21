package com.nk.models.idao;

import java.util.List;

public interface IObjectDAO<T, K> {

    public abstract boolean create(T t);

    public abstract T read(K key);

    public abstract List<T> readAll();

    public abstract boolean update(T t);

    public abstract boolean delete(K key);

}
