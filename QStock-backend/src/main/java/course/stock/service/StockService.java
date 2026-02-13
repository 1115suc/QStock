package course.stock.service;

import course.stock.pojo.domain.InnerMarketDomain;
import course.stock.pojo.domain.Stock4EvrDayDomain;
import course.stock.pojo.domain.Stock4MinuteDomain;
import course.stock.pojo.domain.StockBlockDomain;
import course.stock.pojo.entity.StockBusiness;
import course.stock.pojo.vo.resp.PageResult;
import course.stock.pojo.vo.resp.R;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface StockService {
    // 获取所有股票业务信息
    R<List<StockBusiness>> getAllStockBusiness();
    // 获取国内大盘的实时数据
    R<List<InnerMarketDomain>> innerIndexAll();
    // 获取沪深两市板块最新数据，以交易总金额降序查询，取前10条数据
    R<List<StockBlockDomain>> sectorAllLimit();
    // 分页查询股票最新数据，并按照涨幅排序查询
    R<PageResult> getStockPageInfo(Integer page, Integer pageSize);
    // 统计最新交易日下股票每分钟涨跌停的数量
    R<Map> getStockUpdownCount();
    // 导出所有股票数据到Excel文件
    void stockExport(HttpServletResponse response, Integer page, Integer pageSize);
    // 统计国内A股大盘T日和T-1日成交量对比功能（成交量为沪市和深市成交量之和）
    R<Map> stockTradeVol4InnerMarket();
    // 查询当前时间下股票的涨跌幅度区间统计功能，如果当前日期不在有效时间内，则以最近的一个股票交易时间作为查询点
    R<Map> stockUpDownScopeCount();
    // 查询单个个股的分时行情数据，也就是统计指定股票T日每分钟的交易数据；
    R<List<Stock4MinuteDomain>> stockScreenTimeSharing(String code);
    // 单个个股日K 数据查询 ，可以根据时间区间查询数日的K线数据
    R<List<Stock4EvrDayDomain>> stockCreenDkLine(String code);
}