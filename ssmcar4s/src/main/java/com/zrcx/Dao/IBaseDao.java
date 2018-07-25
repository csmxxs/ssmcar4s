package com.zrcx.Dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<E> {
   public E findById(Long id);
   public List<E> list(Map<String,Object> param);
   public int add(E entity);
   public int update(E obj);
   public int delete(Long id);
}
