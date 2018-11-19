package quytn.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quytn.eas.entity.Details;
import quytn.eas.repository.DetailsRepository;
import quytn.eas.repository.InvoiceRepository;

import java.time.LocalDate;

@Component
public class TestComponent implements CommandLineRunner {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    @Override
    public void run(String... args) throws Exception {
        LocalDate begin = LocalDate.of(2018, 10, 1);
        LocalDate end = LocalDate.of(2018, 11, 30);
        System.out.println(detailsRepository.findByInvoiceInvoiceDateIsGreaterThanEqualAndInvoiceInvoiceDateLessThanEqual(begin, end));
    }

}
