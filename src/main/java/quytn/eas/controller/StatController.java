package quytn.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quytn.eas.common.Constant;
import quytn.eas.common.CustomeDate;
import quytn.eas.common.DateUtil;
import quytn.eas.common.Stat;
import quytn.eas.service.StatService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StatController {

    @Autowired
    private StatService statService;

    @RequestMapping(value = "stat/{category}", method = RequestMethod.GET)
    public String getStatByCategory(@PathVariable String category, Model model){
        CustomeDate date = DateUtil.getCustomeDateByLocalDate(LocalDate.now());
        List<Stat> statList = new ArrayList<>();
        while(!DateUtil.isBefore(date, Constant.START_DATE)){
            Stat stat = new Stat();
            stat.setCategory(category);
            stat.setCustomeDate(date);
            stat = statService.getStatByStatProperty(stat);
            statList.add(stat);
            date = DateUtil.prevMonth(stat.getCategory(), date);
        }
        model.addAttribute("statList", statList);
        return "statistic";
    }
}
