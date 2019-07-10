package com.ms.appservice.repository;


import com.ms.appservice.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

/**
 * Created by khawar on 1/31/19.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, UUID>  {
    List<T> findAllByDeleted(Boolean deleted);
//    List<T> saveAll(Iterable<T> list);
    T findByName(String name);
    List<T> findByNameContainingIgnoreCase(String keyword);




}
