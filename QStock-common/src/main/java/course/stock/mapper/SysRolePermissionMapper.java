package course.stock.mapper;

import course.stock.pojo.entity.SysRolePermission;

/**
* @author 32147
* @description 针对表【sys_role_permission(角色权限表)】的数据库操作Mapper
* @createDate 2026-02-07 17:27:47
* @Entity course.stock.pojo.entity.SysRolePermission
*/
public interface SysRolePermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

}
