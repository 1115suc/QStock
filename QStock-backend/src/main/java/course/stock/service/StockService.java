package course.stock.service;

import course.stock.pojo.domain.InnerMarketDomain;
import course.stock.pojo.entity.StockBusiness;
import course.stock.pojo.vo.resp.R;

import java.util.List;

public interface StockService {
    // 获取所有股票业务信息
    public List<StockBusiness> getAllStockBusiness();
    // 获取国内大盘的实时数据
    R<List<InnerMarketDomain>> innerIndexAll();
}