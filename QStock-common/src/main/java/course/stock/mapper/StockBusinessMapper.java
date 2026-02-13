package course.stock.mapper;

import course.stock.pojo.entity.StockBusiness;

import java.util.List;

/**
* @author 32147
* @description 针对表【stock_business(主营业务表)】的数据库操作Mapper
* @createDate 2026-02-07 17:27:47
* @Entity course.stock.pojo.entity.StockBusiness
*/
public interface StockBusinessMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockBusiness record);

    int insertSelective(StockBusiness record);

    StockBusiness selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockBusiness record);

    int updateByPrimaryKey(StockBusiness record);

    List<StockBusiness> findAll();

    /**
     * 获取所有股票的code
     * @return
     */
    List<String> getStockIds();

}
