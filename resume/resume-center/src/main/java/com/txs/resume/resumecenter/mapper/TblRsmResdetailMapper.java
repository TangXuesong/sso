package com.txs.resume.resumecenter.mapper;

import com.txs.resume.resumecenter.pojo.TblRsmResdetail;

public interface TblRsmResdetailMapper {
    int deleteByPrimaryKey(Integer rlId);

    int insert(TblRsmResdetail record);

    int insertSelective(TblRsmResdetail record);

    TblRsmResdetail selectByPrimaryKey(Integer rlId);

    int updateByPrimaryKeySelective(TblRsmResdetail record);

    int updateByPrimaryKey(TblRsmResdetail record);
}