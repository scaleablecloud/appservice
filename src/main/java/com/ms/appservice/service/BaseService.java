package com.ms.appservice.service;


import com.ms.appservice.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BaseService<T extends BaseModel> {
    public T insert(T item);
    public List<T> saveAll(Iterable<T> list);
    public List<T> findAll();
    public List<T> searchByName(String keyword);
    public List<T> getAll();
    public T findById(UUID id);
    public T delete(UUID id);
    public T deleteSoft(UUID id);
    public T update(T item);
    public T findByName(String name);
    boolean exists(String name);
    public Page<T> findListPage(Pageable pageable);

}
