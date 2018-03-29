package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.DataDic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDicDao {

    public List<DataDic> queryDataDicValueByDataDicName(@Param("dataDicName") String dataDicName);
}
