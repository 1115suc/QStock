package course.stock.mapper;

import course.stock.pojo.domain.Stock4EvrDayDomain;
import course.stock.pojo.domain.Stock4MinuteDomain;
import course.stock.pojo.domain.StockUpdownDomain;
import course.stock.pojo.entity.StockRtInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 32147
 * @description 针对表【stock_rt_info(个股详情信息表)】的数据库操作Mapper
 * @createDate 2026-02-07 17:27:47
 * @Entity course.stock.pojo.entity.StockRtInfo
 */
@SuppressWarnings("MybatisXMapperMethodInspection")
public interface StockRtInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockRtInfo record);

    int insertSelective(StockRtInfo record);

    StockRtInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockRtInfo record);

    int updateByPrimaryKey(StockRtInfo record);

    /**
     * 查询指定时间点下股票的数据，并按照涨幅降序排序
     *
     * @param curDate
     * @return
     */
    List<StockUpdownDomain> getNewestStockInfo(@Param("timePoint") Date curDate);

    /**
     * 查询指定时间范围内每分钟涨停或者跌停的数量
     *
     * @param openTime 开始时间
     * @param curTime  结束时间 一般开始时间和结束时间在同一天
     * @param flag     约定:1->涨停 0:->跌停
     * @return
     */
    @SuppressWarnings("MybatisXMapperMethodInspection")
    List<Map> getStockUpdownCount(@Param("openTime") Date openTime, @Param("curTime") Date curTime, @Param("flag") int flag);


    /**
     * 查询指定时间范围内所有股票的涨幅信息
     *
     * @param curDate
     * @return
     */
    List<StockUpdownDomain> getAllStockUpDownByTime(@Param("curDate") Date curDate);

    /**
     * 统计指定时间点下，各个涨跌区间内股票的个数
     * @param avlDate
     * @return
     */
    List<Map> getStockUpDownSectionByTime(@Param("avlDate") Date avlDate);

    /**
     * 根据时间范围查询指定股票的交易流水
     * @param stockCode 股票code
     * @param startTime 起始时间
     * @param endTime 终止时间
     * @return
     */
    List<Stock4MinuteDomain> getStockInfoByCodeAndDate(@Param("stockCode") String stockCode,
                                                       @Param("startTime") Date startTime,
                                                       @Param("endTime") Date endTime);


    /**
     * 查询指定日期范围内指定股票每天的交易数据
     * @param stockCode 股票code
     * @param startTime 起始时间
     * @param endTime 终止时间
     * @return
     */
    List<Stock4EvrDayDomain> getStockInfo4EvrDay(@Param("stockCode") String stockCode,
                                                 @Param("startTime") Date startTime,
                                                 @Param("endTime") Date endTime);

    int insertBatch(List<StockRtInfo> stockRtInfoList);
}
