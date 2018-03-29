package com.shsxt.crm.biz.controller.dic;

import com.shsxt.crm.biz.model.DataDic;
import com.shsxt.crm.biz.service.IDataDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据字典
 */
@Controller
@RequestMapping("/dic")
public class DateDicController {

    @Autowired
    private IDataDicService dataDicService;



    @RequestMapping("/queryDataDicValueByDataDicName")
    @ResponseBody
    public List<DataDic>  queryDataDicValueByDataDicName (String  dataDicName) {
        return dataDicService.queryDataDicValueByDataDicName(dataDicName);
    }


}
