package com.txs.resume.resumecenter.mapper;

import com.txs.resume.resumecenter.pojo.TblRsmWorkexp;

public interface TblRsmWorkexpMapper {
    int deleteByPrimaryKey(Integer wpId);

    int insert(TblRsmWorkexp record);

    int insertSelective(TblRsmWorkexp record);

    TblRsmWorkexp selectByPrimaryKey(Integer wpId);

    int updateByPrimaryKeySelective(TblRsmWorkexp record);

    int updateByPrimaryKey(TblRsmWorkexp record);
}