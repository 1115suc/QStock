package course.stock.mapper;

import course.stock.pojo.entity.SysUser;

/**
* @author 32147
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2026-02-07 17:27:47
* @Entity course.stock.pojo.entity.SysUser
*/
public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findByUserName(String username);

}
