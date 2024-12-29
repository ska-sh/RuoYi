package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TProjectUser;

/**
 * 项目人员管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface TProjectUserMapper 
{
    /**
     * 查询项目人员管理
     * 
     * @param id 项目人员管理主键
     * @return 项目人员管理
     */
    public TProjectUser selectTProjectUserById(Long id);

    /**
     * 查询项目人员管理列表
     * 
     * @param tProjectUser 项目人员管理
     * @return 项目人员管理集合
     */
    public List<TProjectUser> selectTProjectUserList(TProjectUser tProjectUser);

    /**
     * 新增项目人员管理
     * 
     * @param tProjectUser 项目人员管理
     * @return 结果
     */
    public int insertTProjectUser(TProjectUser tProjectUser);

    /**
     * 修改项目人员管理
     * 
     * @param tProjectUser 项目人员管理
     * @return 结果
     */
    public int updateTProjectUser(TProjectUser tProjectUser);

    /**
     * 删除项目人员管理
     * 
     * @param id 项目人员管理主键
     * @return 结果
     */
    public int deleteTProjectUserById(Long id);

    /**
     * 批量删除项目人员管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectUserByIds(String[] ids);
}
