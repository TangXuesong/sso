package com.txs.resume.resumecenter.mapper;

import com.txs.resume.resumecenter.pojo.TblRsmProjexp;

public interface TblRsmProjexpMapper {
    int deleteByPrimaryKey(Integer ppId);

    int insert(TblRsmProjexp record);

    int insertSelective(TblRsmProjexp record);

    TblRsmProjexp selectByPrimaryKey(Integer ppId);

    int updateByPrimaryKeySelective(TblRsmProjexp record);

    int updateByPrimaryKey(TblRsmProjexp record);
}