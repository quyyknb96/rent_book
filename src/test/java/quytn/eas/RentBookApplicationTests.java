package quytn.eas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quytn.eas.common.CustomeDate;
import quytn.eas.common.Stat;
import quytn.eas.common.StatDetail;
import quytn.eas.entity.Manager;
import quytn.eas.service.ManagerService;
import quytn.eas.service.StatDetailService;
import quytn.eas.service.StatService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentBookApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(RentBookApplicationTests.class);

    @Autowired
    private ManagerService managerService;

    @Autowired
    private StatService statService;

    @Autowired
    private StatDetailService statDetailService;

    @Test
    public void testLogin() {
        Manager manager = new Manager();
        manager.setUsername("admin");
        manager.setPassword("admin");
        log.info("Begin test login by user = {}", manager);
        Assert.assertNotNull(managerService.checkLogin(manager));
    }

    @Test
    public void testStat() {
        Stat stat = new Stat();
        stat.setCategory("month");
        stat.setCustomeDate(new CustomeDate(11,4,2018));
        log.info("Begin test Stat by stat = {}", stat);
        Assert.assertEquals(statService.getStatByStatProperty(stat).getLabel(), "Tháng 11 Năm 2018");
        Assert.assertEquals(statService.getStatByStatProperty(stat).getTotalCost(), 1241300,00);
    }

    @Test
    public void testStatDetail() {
        StatDetail statDetail = new StatDetail();
        String category = "month";
        CustomeDate customeDate = new CustomeDate(11, 4, 2018);
        log.info("Begin test StatDetail by category = {} and customDate = {}", category, customeDate);
        Assert.assertEquals(statDetailService.getAllStatDetail(category, customeDate).size(), 2);
    }

}
