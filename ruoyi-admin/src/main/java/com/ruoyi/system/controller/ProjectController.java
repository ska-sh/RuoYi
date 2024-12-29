package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.TProject;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目基础Controller
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Controller
@RequestMapping("/system/project")
public class ProjectController extends BaseController
{
    private String prefix = "system/project";

    @Autowired
    private ITProjectService tProjectService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询项目基础列表
     */
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProject tProject)
    {
        startPage();
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        return getDataTable(list);
    }

    /**
     * 导出项目基础列表
     */
    @RequiresPermissions("system:project:export")
    @Log(title = "项目基础", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProject tProject)
    {
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        ExcelUtil<TProject> util = new ExcelUtil<TProject>(TProject.class);
        return util.exportExcel(list, "项目基础数据");
    }

    /**
     * 新增项目基础
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("users", userService.selectUserAll());
        return prefix + "/add";
    }

    /**
     * 新增保存项目基础
     */
    @RequiresPermissions("system:project:add")
    @Log(title = "项目基础", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProject tProject)
    {
        tProject.setCreateBy(getUserName());
        return toAjax(tProjectService.insertTProject(tProject));
    }

    /**
     * 修改项目基础
     */
    @RequiresPermissions("system:project:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProject tProject = tProjectService.selectTProjectById(id);
        mmap.put("tProject", tProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目基础
     */
    @RequiresPermissions("system:project:edit")
    @Log(title = "项目基础", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProject tProject)
    {
        tProject.setUpdateBy(getUserName());
        return toAjax(tProjectService.updateTProject(tProject));
    }

    /**
     * 删除项目基础
     */
    @RequiresPermissions("system:project:remove")
    @Log(title = "项目基础", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectService.deleteTProjectByIds(ids));
    }
}
