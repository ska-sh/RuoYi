package com.ruoyi.system.controller;

import java.util.List;

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
import com.ruoyi.system.domain.TProjectSubitem;
import com.ruoyi.system.service.ITProjectSubitemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 子项目Controller
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Controller
@RequestMapping("/system/subitem")
public class ProjectSubitemController extends BaseController
{
    private String prefix = "system/subitem";

    @Autowired
    private ITProjectSubitemService tProjectSubitemService;

    @Autowired
    private ITProjectService projectService;

    @RequiresPermissions("system:subitem:view")
    @GetMapping()
    public String subitem()
    {
        return prefix + "/subitem";
    }

    /**
     * 查询子项目列表
     */
    @RequiresPermissions("system:subitem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectSubitem tProjectSubitem)
    {
        startPage();
        List<TProjectSubitem> list = tProjectSubitemService.selectTProjectSubitemList(tProjectSubitem);
        return getDataTable(list);
    }

    /**
     * 导出子项目列表
     */
    @RequiresPermissions("system:subitem:export")
    @Log(title = "子项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectSubitem tProjectSubitem)
    {
        List<TProjectSubitem> list = tProjectSubitemService.selectTProjectSubitemList(tProjectSubitem);
        ExcelUtil<TProjectSubitem> util = new ExcelUtil<TProjectSubitem>(TProjectSubitem.class);
        return util.exportExcel(list, "子项目数据");
    }

    /**
     * 新增子项目
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("projects", projectService.selectTProjectList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存子项目
     */
    @RequiresPermissions("system:subitem:add")
    @Log(title = "子项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectSubitem tProjectSubitem)
    {
        tProjectSubitem.setCreateBy(getUserName());
        return toAjax(tProjectSubitemService.insertTProjectSubitem(tProjectSubitem));
    }

    /**
     * 修改子项目
     */
    @RequiresPermissions("system:subitem:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectSubitem tProjectSubitem = tProjectSubitemService.selectTProjectSubitemById(id);
        mmap.put("tProjectSubitem", tProjectSubitem);
        return prefix + "/edit";
    }

    /**
     * 修改保存子项目
     */
    @RequiresPermissions("system:subitem:edit")
    @Log(title = "子项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectSubitem tProjectSubitem)
    {
        return toAjax(tProjectSubitemService.updateTProjectSubitem(tProjectSubitem));
    }

    /**
     * 删除子项目
     */
    @RequiresPermissions("system:subitem:remove")
    @Log(title = "子项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectSubitemService.deleteTProjectSubitemByIds(ids));
    }
}
