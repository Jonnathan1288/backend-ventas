package com.proyecto.empresa.controller.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

public interface GenericController <T, ID extends Serializable> {
    public ResponseEntity<List<T>> findByAll();
    public ResponseEntity<Page<T>> findByAll(@PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable);
    public ResponseEntity<T> findByOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody T entity);
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity);
}
