package com.shsxt.crm.biz.service.impl;

import com.shsxt.crm.biz.dao.DataDicDao;
import com.shsxt.crm.biz.model.DataDic;
import com.shsxt.crm.biz.service.IDataDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDicServiceImpl implements IDataDicService {

    @Autowired
    private DataDicDao dataDicDao;

    /***
     *
     * @param dataDicName
     * @return
     */
    @Override
    public List<DataDic> queryDataDicValueByDataDicName(String dataDicName) {
        List<DataDic> dataDics = dataDicDao.queryDataDicValueByDataDicName(dataDicName);
        return dataDics;
    }

}
