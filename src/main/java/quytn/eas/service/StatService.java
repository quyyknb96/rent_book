package quytn.eas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quytn.eas.common.CustomeDate;
import quytn.eas.common.DateUtil;
import quytn.eas.common.Stat;
import quytn.eas.entity.Details;
import quytn.eas.repository.DetailsRepository;

import java.time.LocalDate;

@Service
public class StatService {

    @Autowired
    private DetailsRepository detailsRepository;

    public Stat getStatByStatProperty(Stat stat){
        switch (stat.getCategory()){
            case "month":
                stat.setLabel("Tháng " + stat.getCustomeDate().getMonth() + " Năm " + stat.getCustomeDate().getYear());
                break;
            case "quarter":
                stat.setLabel("Quý " + stat.getCustomeDate().getQuarter() + " Năm " + stat.getCustomeDate().getYear());
                break;
            case "year":
                stat.setLabel("Năm " + stat.getCustomeDate().getYear());
                break;
        }
        stat.setTotalCost(getTotalCostStat(stat));
        CustomeDate date = new CustomeDate(stat.getCustomeDate().getMonth(), stat.getCustomeDate().getQuarter(), stat.getCustomeDate().getYear());
        stat.setCustomeDate(date);
        return stat;
    }

    public float getTotalCostStat(Stat stat){
        LocalDate begin = DateUtil.getFirstDay(stat.getCategory(), stat.getCustomeDate());
        LocalDate end = DateUtil.getLastDay(stat.getCategory(), stat.getCustomeDate());
        float result = 0;
        for ( Details details : detailsRepository.findByInvoiceInvoiceDateIsGreaterThanEqualAndInvoiceInvoiceDateLessThanEqual(begin, end)) {
            int dayNumber = DateUtil.getDayNumberBetween(details.getRent().getRentDate(), details.getInvoice().getInvoiceDate());
            result += dayNumber * details.getBook().getPrice() + isFloatNull(details.getPenalty());
        }
        return result;
    }

    public static float isFloatNull(Float aFloat){
        if (aFloat != null) {
            return aFloat;
        } else {
            return 0;
        }
    }
}
