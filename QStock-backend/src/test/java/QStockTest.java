import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import course.stock.QStockApplication;
import course.stock.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest(classes = QStockApplication.class)
@Slf4j
public class QStockTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void RedisTest() {
        Map<Object, Object> build = MapUtil.builder()
                .put("name", "李四")
                .put("age", 20)
                .put("gender", "男")
                .put("address", "北京")
                .build();
        JSONUtil.toJsonStr(build);
        System.out.println(build);
        redisUtil.set("Test:User", build, 60 * 60);
    }
}
