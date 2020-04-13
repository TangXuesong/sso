package com.txs.resume.resumecenter.mapper;

import com.txs.resume.resumecenter.pojo.TblRsmResume;

public interface TblRsmResumeMapper {
    int deleteByPrimaryKey(Integer rsId);

    int insert(TblRsmResume record);

    int insertSelective(TblRsmResume record);

    TblRsmResume selectByPrimaryKey(Integer rsId);

    int updateByPrimaryKeySelective(TblRsmResume record);

    int updateByPrimaryKey(TblRsmResume record);
}