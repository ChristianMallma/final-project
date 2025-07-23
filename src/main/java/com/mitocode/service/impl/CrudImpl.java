package com.mitocode.service.impl;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.repository.interfaces.IGenericRepo;
import com.mitocode.service.interfaces.ICrud;

import java.util.List;

public abstract class CrudImpl<T, ID> implements ICrud<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not found: "+ id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not found: "+ id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not found: "+ id));
        getRepo().deleteById(id);
    }
}
