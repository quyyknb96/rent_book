package quytn.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quytn.eas.common.CustomeDate;
import quytn.eas.common.StatDetail;
import quytn.eas.service.StatDetailService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StatDetailContronller {

    @Autowired
    private StatDetailService statDetailService;

    @RequestMapping(value = "/statDetail/{category}", method = RequestMethod.GET)
    public String getStatDetail(CustomeDate customeDate, @PathVariable String category, Model model){
        List<StatDetail> detailList = statDetailService.getAllStatDetail(category, customeDate);
        model.addAttribute("detailList", detailList);
        return "statisticDetail";
    }
}
