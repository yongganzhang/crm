package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.DataDic;

import java.util.List;

public interface IDataDicService {

    public List<DataDic>  queryDataDicValueByDataDicName (String  dataDicName);
}
