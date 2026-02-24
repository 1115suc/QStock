import com.google.common.collect.Lists;
import course.stock.JobApplication;
import course.stock.service.StockTimerTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest( classes = JobApplication.class )
class StockTimerTaskServiceImplTest {
    @Autowired
    private StockTimerTaskService stockTimerTaskService;

    @Test
    void getInnerMarketInfo() {
        stockTimerTaskService.getInnerMarketInfo();
    }

    @Test
    public void testPartion() {
        List<Integer> all=new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            all.add(i);
        }
        //将集合均等分，每份大小最多15个
        Lists.partition(all,15).forEach(ids->{
            System.out.println(ids);
        });
    }

    @Test
    void getJobApplication() {
        stockTimerTaskService.getStockRtIndex();
    }
}