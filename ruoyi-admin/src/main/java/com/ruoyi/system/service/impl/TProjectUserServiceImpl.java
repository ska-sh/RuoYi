package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TProjectUserMapper;
import com.ruoyi.system.domain.TProjectUser;
import com.ruoyi.system.service.ITProjectUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目人员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Service
public class TProjectUserServiceImpl implements ITProjectUserService 
{
    @Autowired
    private TProjectUserMapper tProjectUserMapper;

    /**
     * 查询项目人员管理
     * 
     * @param id 项目人员管理主键
     * @return 项目人员管理
     */
    @Override
    public TProjectUser selectTProjectUserById(Long id)
    {
        return tProjectUserMapper.selectTProjectUserById(id);
    }

    /**
     * 查询项目人员管理列表
     * 
     * @param tProjectUser 项目人员管理
     * @return 项目人员管理
     */
    @Override
    public List<TProjectUser> selectTProjectUserList(TProjectUser tProjectUser)
    {
        return tProjectUserMapper.selectTProjectUserList(tProjectUser);
    }

    /**
     * 新增项目人员管理
     * 
     * @param tProjectUser 项目人员管理
     * @return 结果
     */
    @Override
    public int insertTProjectUser(TProjectUser tProjectUser)
    {
        tProjectUser.setCreateTime(DateUtils.getNowDate());
        if(tProjectUser.getUserIds() != null){
            for(Long userId : tProjectUser.getUserIds()){
                tProjectUser.setUserId(userId);
                return tProjectUserMapper.insertTProjectUser(tProjectUser);
            }
        }
        return 0;
    }

    /**
     * 修改项目人员管理
     * 
     * @param tProjectUser 项目人员管理
     * @return 结果
     */
    @Override
    public int updateTProjectUser(TProjectUser tProjectUser)
    {
        tProjectUser.setUpdateTime(DateUtils.getNowDate());
        return tProjectUserMapper.updateTProjectUser(tProjectUser);
    }

    /**
     * 批量删除项目人员管理
     * 
     * @param ids 需要删除的项目人员管理主键
     * @return 结果
     */
    @Override
    public int deleteTProjectUserByIds(String ids)
    {
        return tProjectUserMapper.deleteTProjectUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目人员管理信息
     * 
     * @param id 项目人员管理主键
     * @return 结果
     */
    @Override
    public int deleteTProjectUserById(Long id)
    {
        return tProjectUserMapper.deleteTProjectUserById(id);
    }
}
