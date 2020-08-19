package com.zwy.accounting.controller;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import com.zwy.accounting.entity.ModuleEntity;
import com.zwy.accounting.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Afauria on 2019/2/25.
 */
@RestController//相当于@Controller+@ResponseBody
@RequestMapping(value = "/api/module")
@CrossOrigin
public class ModuleController {
//    @Autowired
    private ModuleService mModuleService;

    @GetMapping("/list")
    public Result listModules(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                      int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                      int pageSize) {
        return ResultUtil.success(mModuleService.listModules(pageNum, pageSize));
    }

    @PostMapping("/add")
    public Result addModule(@RequestBody ModuleEntity module) {
        return ResultUtil.success(mModuleService.addModule(module));
    }

    @PostMapping("/remove")
    public Result removeModule(Integer moduleId) {
        return ResultUtil.success(mModuleService.removeModuleById(moduleId));
    }

    @PostMapping("/modify")
    public Result modifyModule(@RequestBody ModuleEntity moduleEntity) {
        return ResultUtil.success(mModuleService.modifyModule(moduleEntity));
    }

    @PostMapping("/searchNextVersion")
    public Result searchNextVersion(String curVersion, boolean rcFlag) {
        String nextVersion = mModuleService.searchNextVersion(curVersion, rcFlag);
        return ResultUtil.success(nextVersion);
    }

    @GetMapping("/history")
    public Result findModuleBuildHistory(@RequestParam("moduleId") int moduleId,
                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") int
                                                 pageSize) {
        return ResultUtil.success(mModuleService.findModuleBuildHistory(moduleId, pageNum, pageSize));
    }

    @PostMapping("/buildReport")
    public Result findModuleBuildReport(int buildId) {
        return ResultUtil.success(mModuleService.findModuleBuildReport(buildId));
    }

    @PostMapping("/build")
    public Result buildModule(Integer moduleId, String version) {
        return ResultUtil.success(mModuleService.buildModule(moduleId, version));
    }

    @PostMapping("/searchVersions")
    public Result searchVersions(Integer moduleId) {
        return ResultUtil.success(mModuleService.searchVersions(moduleId));
    }

    @PostMapping("/searchEnableModulesName")
    public Result searchEnableModulesName(int projectId){
        return ResultUtil.success(mModuleService.searchEnableModulesName(projectId));
    }
}
