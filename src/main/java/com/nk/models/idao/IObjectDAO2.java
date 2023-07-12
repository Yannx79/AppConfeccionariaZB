package com.nk.models.idao;

import java.util.List;

public interface IObjectDAO2<T, K> {

    public abstract boolean create(T t);

    public abstract T read(K key, K key2);

    public abstract List<T> readAll();

    public abstract boolean update(T t);

    public abstract boolean delete(K key, K key2);
}
