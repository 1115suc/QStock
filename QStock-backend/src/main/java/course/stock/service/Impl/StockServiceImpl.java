package course.stock.service.Impl;

import course.stock.config.StockInfoConfig;
import course.stock.mapper.StockBusinessMapper;
import course.stock.mapper.StockMarketIndexInfoMapper;
import course.stock.pojo.domain.InnerMarketDomain;
import course.stock.pojo.entity.StockBusiness;
import course.stock.pojo.vo.resp.R;
import course.stock.service.StockService;
import course.stock.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service("stockService")
public class StockServiceImpl implements StockService {

    private final StockBusinessMapper stockBusinessMapper;
    private final StockMarketIndexInfoMapper stockMarketIndexInfoMapper;
    private final StockInfoConfig stockInfoConfig;

    @Override
    public List<StockBusiness> getAllStockBusiness() {
        return stockBusinessMapper.findAll();
    }

    // 获取国内大盘的实时数据
    @Override
    public R<List<InnerMarketDomain>> innerIndexAll() {
        //1.获取国内A股大盘的id集合
        List<String> inners = stockInfoConfig.getInner();
        //2.获取最近股票交易日期
        Date lastDate = DateTimeUtil.getLastDate4Stock(DateTime.now()).toDate();
        //TODO mock测试数据，后期数据通过第三方接口动态获取实时数据 可删除
        lastDate=DateTime.parse("2022-01-02 09:32:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        //3.将获取的java Date传入接口
        List<InnerMarketDomain> list= stockMarketIndexInfoMapper.getMarketInfo(inners,lastDate);
        //4.返回查询结果
        return R.ok(list);
    }
}