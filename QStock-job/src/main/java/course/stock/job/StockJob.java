package course.stock.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class StockJob {
    @XxlJob("QStock_job_test")
    public void jobTest(){
        System.out.println("测试接口");
    }
}