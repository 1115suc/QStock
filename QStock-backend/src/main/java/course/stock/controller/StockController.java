package course.stock.controller;

import course.stock.pojo.domain.InnerMarketDomain;
import course.stock.pojo.vo.resp.R;
import course.stock.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "国内大盘指数", tags = {"国内大盘指数"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quot")
public class StockController {

    private final StockService stockService;

    // 获取国内最新大盘指数
    @ApiOperation(value = "获取国内最新大盘指数", notes = "获取国内最新大盘指数", httpMethod = "GET")
    @GetMapping("/index/all")
    public R<List<InnerMarketDomain>> innerIndexAll(){
        return stockService.innerIndexAll();
    }
}