package course.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("course.stock.mapper")
@SpringBootApplication
public class QStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(QStockApplication.class, args);
    }
}
