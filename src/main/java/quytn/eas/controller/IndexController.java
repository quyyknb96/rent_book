package quytn.eas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quytn.eas.common.CustomeDate;
import quytn.eas.common.DateUtil;

import java.time.LocalDate;

@Controller
public class IndexController {

    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String index(){
        LocalDate localDate = LocalDate.now();
        CustomeDate customeDate = DateUtil.getCustomeDateByLocalDate(localDate);
        LocalDate date = DateUtil.getFirstDay("quarter",customeDate);
        LocalDate date1 = DateUtil.getLastDay("quarter",customeDate);
        return "index";
    }
}
