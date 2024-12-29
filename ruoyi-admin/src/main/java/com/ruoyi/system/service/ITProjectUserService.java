package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TProjectUser;

/**
 * 项目人员管理Service接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface ITProjectUserService 
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
     * 批量删除项目人员管理
     * 
     * @param ids 需要删除的项目人员管理主键集合
     * @return 结果
     */
    public int deleteTProjectUserByIds(String ids);

    /**
     * 删除项目人员管理信息
     * 
     * @param id 项目人员管理主键
     * @return 结果
     */
    public int deleteTProjectUserById(Long id);
}
