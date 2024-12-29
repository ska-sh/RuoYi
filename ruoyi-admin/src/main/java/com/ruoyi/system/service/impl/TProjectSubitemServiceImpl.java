package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TProjectSubitemMapper;
import com.ruoyi.system.domain.TProjectSubitem;
import com.ruoyi.system.service.ITProjectSubitemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 子项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Service
public class TProjectSubitemServiceImpl implements ITProjectSubitemService 
{
    @Autowired
    private TProjectSubitemMapper tProjectSubitemMapper;

    /**
     * 查询子项目
     * 
     * @param id 子项目主键
     * @return 子项目
     */
    @Override
    public TProjectSubitem selectTProjectSubitemById(Long id)
    {
        return tProjectSubitemMapper.selectTProjectSubitemById(id);
    }

    /**
     * 查询子项目列表
     * 
     * @param tProjectSubitem 子项目
     * @return 子项目
     */
    @Override
    public List<TProjectSubitem> selectTProjectSubitemList(TProjectSubitem tProjectSubitem)
    {
        return tProjectSubitemMapper.selectTProjectSubitemList(tProjectSubitem);
    }

    /**
     * 新增子项目
     * 
     * @param tProjectSubitem 子项目
     * @return 结果
     */
    @Override
    public int insertTProjectSubitem(TProjectSubitem tProjectSubitem)
    {
        tProjectSubitem.setCreateTime(DateUtils.getNowDate());
        return tProjectSubitemMapper.insertTProjectSubitem(tProjectSubitem);
    }

    /**
     * 修改子项目
     * 
     * @param tProjectSubitem 子项目
     * @return 结果
     */
    @Override
    public int updateTProjectSubitem(TProjectSubitem tProjectSubitem)
    {
        tProjectSubitem.setUpdateTime(DateUtils.getNowDate());
        return tProjectSubitemMapper.updateTProjectSubitem(tProjectSubitem);
    }

    /**
     * 批量删除子项目
     * 
     * @param ids 需要删除的子项目主键
     * @return 结果
     */
    @Override
    public int deleteTProjectSubitemByIds(String ids)
    {
        return tProjectSubitemMapper.deleteTProjectSubitemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除子项目信息
     * 
     * @param id 子项目主键
     * @return 结果
     */
    @Override
    public int deleteTProjectSubitemById(Long id)
    {
        return tProjectSubitemMapper.deleteTProjectSubitemById(id);
    }
}
