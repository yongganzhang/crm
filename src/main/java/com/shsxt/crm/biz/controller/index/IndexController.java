package com.shsxt.crm.biz.controller.index;

import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页跳转
 */
@Controller
public class IndexController extends BaseController {

    @GetMapping("index")
    public  String index () {
        return "index";
    }
}
