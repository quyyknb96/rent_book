package quytn.eas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quytn.eas.common.CustomeDate;
import quytn.eas.common.DateUtil;
import quytn.eas.common.Stat;
import quytn.eas.common.StatDetail;
import quytn.eas.entity.Details;
import quytn.eas.entity.Invoice;
import quytn.eas.repository.DetailsRepository;
import quytn.eas.repository.InvoiceRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class StatDetailService {

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<StatDetail> getAllStatDetail(String category, CustomeDate customeDate){
        List<StatDetail> list = new ArrayList<>();
        LocalDate begin = DateUtil.getFirstDay(category, customeDate);
        LocalDate end = DateUtil.getLastDay(category, customeDate);
        for ( Invoice invoice : invoiceRepository.findByInvoiceDateIsGreaterThanEqualAndInvoiceDateLessThanEqual(begin, end)) {
            StatDetail statDetail = new StatDetail();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Saigon"));
            calendar.setTime(invoice.getInvoiceTime());
            calendar.set(Calendar.YEAR, invoice.getInvoiceDate().getYear());
            calendar.set(Calendar.MONTH, invoice.getInvoiceDate().getMonthValue()-1);
            calendar.set(Calendar.DAY_OF_MONTH, invoice.getInvoiceDate().getDayOfMonth());
            statDetail.setInvoiceDate(calendar.getTime());
            float result = 0;
            for ( Details details : detailsRepository.findByInvoiceId(invoice.getId())) {
                int dayNumber = DateUtil.getDayNumberBetween(details.getRent().getRentDate(), details.getInvoice().getInvoiceDate());
                result += dayNumber * details.getBook().getPrice() + StatService.isFloatNull(details.getPenalty());
                statDetail.setUserName(details.getRent().getUsers().getName());
                statDetail.setRentTotal(statDetail.getRentTotal() + 1);
            }
            statDetail.setCostTotal(result);
            list.add(statDetail);
        }
        return list;
    }
}
