package com.ruoyi.system.service.impl;

import java.util.Collections;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TProject;
import com.ruoyi.system.mapper.TProjectMapper;
import com.ruoyi.system.service.ITProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目基础Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Service
public class TProjectServiceImpl implements ITProjectService
{
    @Autowired
    private TProjectMapper tProjectMapper;

    /**
     * 查询项目基础
     * 
     * @param id 项目基础主键
     * @return 项目基础
     */
    @Override
    public TProject selectTProjectById(Long id)
    {
        return tProjectMapper.selectTProjectById(id);
    }

    /**
     * 查询项目基础列表
     * 
     * @param tProject 项目基础
     * @return 项目基础
     */
    @Override
    public List<TProject> selectTProjectList(TProject tProject)
    {
        return tProjectMapper.selectTProjectList(tProject);
    }

    /**
     * 新增项目基础
     * 
     * @param tProject 项目基础
     * @return 结果
     */
    @Override
    public int insertTProject(TProject tProject)
    {
        tProject.setCreateTime(DateUtils.getNowDate());
        return tProjectMapper.insertTProject(tProject);
    }

    /**
     * 修改项目基础
     * 
     * @param tProject 项目基础
     * @return 结果
     */
    @Override
    public int updateTProject(TProject tProject)
    {
        tProject.setUpdateTime(DateUtils.getNowDate());
        return tProjectMapper.updateTProject(tProject);
    }

    /**
     * 批量删除项目基础
     * 
     * @param ids 需要删除的项目基础主键
     * @return 结果
     */
    @Override
    public int deleteTProjectByIds(String ids)
    {
        return tProjectMapper.deleteTProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目基础信息
     * 
     * @param id 项目基础主键
     * @return 结果
     */
    @Override
    public int deleteTProjectById(Long id)
    {
        return tProjectMapper.deleteTProjectById(id);
    }

}
