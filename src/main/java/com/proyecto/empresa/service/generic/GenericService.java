package com.proyecto.empresa.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, ID extends Serializable>{

    public List<T> findByAll();

    public Page<T> findByAll(Pageable pageable);

    public T save(T entity);

    public T update(ID id, T entity);

    public T findById(ID id);

    public void  delete(ID id);

}