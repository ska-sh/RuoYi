package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TProject;

import java.util.List;

/**
 * 项目基础Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface TProjectMapper 
{
    /**
     * 查询项目基础
     * 
     * @param id 项目基础主键
     * @return 项目基础
     */
    public TProject selectTProjectById(Long id);

    /**
     * 查询项目基础列表
     * 
     * @param tProject 项目基础
     * @return 项目基础集合
     */
    public List<TProject> selectTProjectList(TProject tProject);

    /**
     * 新增项目基础
     * 
     * @param tProject 项目基础
     * @return 结果
     */
    public int insertTProject(TProject tProject);

    /**
     * 修改项目基础
     * 
     * @param tProject 项目基础
     * @return 结果
     */
    public int updateTProject(TProject tProject);

    /**
     * 删除项目基础
     * 
     * @param id 项目基础主键
     * @return 结果
     */
    public int deleteTProjectById(Long id);

    /**
     * 批量删除项目基础
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectByIds(String[] ids);

    List<TProject> selectProjectAll();
}
