package course.stock.mapper;

import course.stock.pojo.entity.SysLog;

/**
* @author 32147
* @description 针对表【sys_log(系统日志)】的数据库操作Mapper
* @createDate 2026-02-07 17:27:47
* @Entity course.stock.pojo.entity.SysLog
*/
public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

}
