package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.ITProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TProjectUser;
import com.ruoyi.system.service.ITProjectUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目人员管理Controller
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Controller
@RequestMapping("/system/project/user")
public class ProjectUserController extends BaseController
{
    private String prefix = "system/project/user";

    @Autowired
    private ITProjectUserService tProjectUserService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ITProjectService projectService;

    @RequiresPermissions("system:project/user:view")
    @GetMapping()
    public String projectUser()
    {
        return prefix + "/project/user";
    }

    /**
     * 查询项目人员管理列表
     */
    @RequiresPermissions("system:project/user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectUser tProjectUser)
    {
        startPage();
        List<TProjectUser> list = tProjectUserService.selectTProjectUserList(tProjectUser);
        return getDataTable(list);
    }

    /**
     * 导出项目人员管理列表
     */
    @RequiresPermissions("system:project/user:export")
    @Log(title = "项目人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectUser tProjectUser)
    {
        List<TProjectUser> list = tProjectUserService.selectTProjectUserList(tProjectUser);
        ExcelUtil<TProjectUser> util = new ExcelUtil<TProjectUser>(TProjectUser.class);
        return util.exportExcel(list, "项目人员管理数据");
    }

    /**
     * 新增项目人员管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("users", userService.selectUserAll());
        mmap.put("projects", projectService.selectTProjectList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存项目人员管理
     */
    @RequiresPermissions("system:project/user:add")
    @Log(title = "项目人员管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectUser tProjectUser)
    {
        tProjectUser.setCreateBy(getUserName());
        return toAjax(tProjectUserService.insertTProjectUser(tProjectUser));
    }

    /**
     * 修改项目人员管理
     */
    @RequiresPermissions("system:project/user:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectUser tProjectUser = tProjectUserService.selectTProjectUserById(id);
        mmap.put("tProjectUser", tProjectUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目人员管理
     */
    @RequiresPermissions("system:project/user:edit")
    @Log(title = "项目人员管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectUser tProjectUser)
    {
        return toAjax(tProjectUserService.updateTProjectUser(tProjectUser));
    }

    /**
     * 删除项目人员管理
     */
    @RequiresPermissions("system:project/user:remove")
    @Log(title = "项目人员管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectUserService.deleteTProjectUserByIds(ids));
    }
}
