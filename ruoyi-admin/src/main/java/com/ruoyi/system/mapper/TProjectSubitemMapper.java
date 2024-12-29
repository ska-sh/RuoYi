package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TProjectSubitem;

/**
 * 子项目Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface TProjectSubitemMapper 
{
    /**
     * 查询子项目
     * 
     * @param id 子项目主键
     * @return 子项目
     */
    public TProjectSubitem selectTProjectSubitemById(Long id);

    /**
     * 查询子项目列表
     * 
     * @param tProjectSubitem 子项目
     * @return 子项目集合
     */
    public List<TProjectSubitem> selectTProjectSubitemList(TProjectSubitem tProjectSubitem);

    /**
     * 新增子项目
     * 
     * @param tProjectSubitem 子项目
     * @return 结果
     */
    public int insertTProjectSubitem(TProjectSubitem tProjectSubitem);

    /**
     * 修改子项目
     * 
     * @param tProjectSubitem 子项目
     * @return 结果
     */
    public int updateTProjectSubitem(TProjectSubitem tProjectSubitem);

    /**
     * 删除子项目
     * 
     * @param id 子项目主键
     * @return 结果
     */
    public int deleteTProjectSubitemById(Long id);

    /**
     * 批量删除子项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectSubitemByIds(String[] ids);
}
