package com.zrcx.Dao;

import com.zrcx.entity.FittingsStock;

public interface IFittingsStockDao extends IBaseDao<FittingsStock> {
  public abstract FittingsStock findByfittingsId(Long id);
}