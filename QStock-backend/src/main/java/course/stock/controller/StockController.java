package course.stock.controller;

import course.stock.constant.ResponseConstant;
import course.stock.pojo.domain.InnerMarketDomain;
import course.stock.pojo.domain.Stock4EvrDayDomain;
import course.stock.pojo.domain.Stock4MinuteDomain;
import course.stock.pojo.domain.StockBlockDomain;
import course.stock.pojo.entity.StockBusiness;
import course.stock.pojo.vo.resp.PageResult;
import course.stock.pojo.vo.resp.R;
import course.stock.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Api(value = "国内大盘指数", tags = {"国内大盘指数"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/quot")
public class StockController {

    private final StockService stockService;

    // 获取所有股票业务信息
    @ApiOperation(value = "获取所有股票业务信息", notes = "获取所有股票业务信息", httpMethod = "GET")
    @GetMapping("/business/all")
    public R<List<StockBusiness>> getAllStockBusiness(){
        return stockService.getAllStockBusiness();
    }

    // 获取国内最新大盘指数
    @ApiOperation(value = "获取国内最新大盘指数", notes = "获取国内最新大盘指数", httpMethod = "GET")
    @GetMapping("/index/all")
    public R<List<InnerMarketDomain>> innerIndexAll(){
        return stockService.innerIndexAll();
    }

    // 获取沪深两市板块最新数据，以交易总金额降序查询，取前10条数据 获取沪深两市板块数据
    @ApiOperation(value = "获取沪深两市板块数据", notes = "获取沪深两市板块最新数据，以交易总金额降序查询，取前10条数据", httpMethod = "GET")
    @GetMapping("/sector/all")
    public R<List<StockBlockDomain>> sectorAll(){
        return stockService.sectorAllLimit();
    }

    // 获取所有股票数据，分页查询
    @ApiOperation(value = "获取所有股票数据", notes = "获取所有股票数据，分页查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "int", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", dataType = "int", paramType = "query", defaultValue = "20")
    })
    @GetMapping("/stock/all")
    public R<PageResult> getStockPageInfo(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
                                          @RequestParam(name = "pageSize",required = false,defaultValue = "20") Integer pageSize){
        return stockService.getStockPageInfo(page,pageSize);
    }

    // 统计最新交易日下股票每分钟涨跌停的数量
    @ApiOperation(value = "统计最新交易日下股票每分钟涨跌停的数量", notes = "统计最新交易日下股票每分钟涨跌停的数量", httpMethod = "GET")
    @GetMapping("/stock/updown/count")
    public R<Map> getStockUpdownCount(){
        return stockService.getStockUpdownCount();
    }

    // 将指定页的股票数据导出到excel表下
    @ApiOperation(value = "将指定页的股票数据导出到excel表下", notes = "将指定页的股票数据导出到excel表下", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "int", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", dataType = "int", paramType = "query", defaultValue = "20")
    })
    @GetMapping("/stock/export")
    public void stockExport(HttpServletResponse response, Integer page, Integer pageSize){
        stockService.stockExport(response,page,pageSize);
    }

    // 功能描述：统计国内A股大盘T日和T-1日成交量对比功能（成交量为沪市和深市成交量之和）
    @ApiOperation(value = "统计国内A股大盘T日和T-1日成交量对比功能", notes = "统计国内A股大盘T日和T-1日成交量对比功能（成交量为沪市和深市成交量之和）", httpMethod = "GET")
    @GetMapping("/stock/tradeAmt")
    public R<Map> stockTradeVol4InnerMarket(){
        return stockService.stockTradeVol4InnerMarket();
    }

    // 查询当前时间下股票的涨跌幅度区间统计功能，如果当前日期不在有效时间内，则以最近的一个股票交易时间作为查询点
    @ApiOperation(value = "查询股票的涨跌幅度区间统计", notes = "查询当前时间下股票的涨跌幅度区间统计功能，如果当前日期不在有效时间内，则以最近的一个股票交易时间作为查询点", httpMethod = "GET")
    @GetMapping("/stock/updown")
    public R<Map> getStockUpDown(){
        return stockService.stockUpDownScopeCount();
    }

    /**
     * 功能描述：查询单个个股的分时行情数据，也就是统计指定股票T日每分钟的交易数据；
     *         如果当前日期不在有效时间内，则以最近的一个股票交易时间作为查询时间点
     * @param code 股票编码
     * @return
     */
    @ApiOperation(value = "查询单个个股的分时行情数据", notes = "查询单个个股的分时行情数据，也就是统计指定股票T日每分钟的交易数据；如果当前日期不在有效时间内，则以最近的一个股票交易时间作为查询时间点", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "股票编码", dataType = "String", paramType = "query", required = true)
    })
    @GetMapping("/stock/screen/time-sharing")
    public R<List<Stock4MinuteDomain>> stockScreenTimeSharing(String code){
        return stockService.stockScreenTimeSharing(code);
    }

    // 单个个股日K 数据查询 ，可以根据时间区间查询数日的K线数据
    @ApiOperation(value = "单个个股日K 数据查询", notes = "单个个股日K 数据查询 ，可以根据时间区间查询数日的K线数据", httpMethod = "GET")
    @RequestMapping("/stock/screen/dkline")
    public R<List<Stock4EvrDayDomain>> getDayKLinData(@RequestParam("code") String stockCode){
        return stockService.stockCreenDkLine(stockCode);
    }
}