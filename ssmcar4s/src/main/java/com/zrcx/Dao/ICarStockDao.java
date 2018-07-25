package com.zrcx.Dao;
import com.zrcx.entity.CarStock;

public interface ICarStockDao extends IBaseDao<CarStock>{
    public abstract CarStock findBycarId(Long id);
}