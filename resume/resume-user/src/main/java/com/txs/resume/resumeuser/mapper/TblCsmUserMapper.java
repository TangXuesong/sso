package com.txs.resume.resumeuser.mapper;

import com.txs.resume.resumeuser.pojo.TblCsmUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TblCsmUserMapper {
    int deleteByPrimaryKey(Integer urId);

    int insert(TblCsmUser record);

    int insertSelective(TblCsmUser record);

    TblCsmUser selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(TblCsmUser record);

    int updateByPrimaryKey(TblCsmUser record);

    TblCsmUser selectByEmail(String email);
}