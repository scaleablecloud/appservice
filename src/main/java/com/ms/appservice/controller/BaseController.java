package com.ms.appservice.controller;


import com.ms.appservice.model.BaseModel;
import com.ms.appservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public class BaseController<S extends BaseService<T>, T extends BaseModel> {

    @Autowired
    S service;

    @GetMapping
    Page<T> getPageable(Pageable pageable) {
        return service.findListPage(pageable);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<T> getAll(Pageable pageable) {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public T insert(@Valid @RequestBody T item) {
        return service.insert(item);
    }

    @PostMapping("/saveall")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<T> saveAll(@Valid @RequestBody Iterable<T> list) {
        return service.saveAll(list);
    }

    @GetMapping("/{uuid}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public T findById(@PathVariable("uuid") UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public T delete(@PathVariable UUID id) {
        return service.delete(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public T update(@RequestBody T item) {
        return service.update(item);
    }
}
