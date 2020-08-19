package com.zwy.accounting.controller;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import com.zwy.accounting.entity.ModuleBuildEntity;
import com.zwy.accounting.entity.ProjectBuildEntity;
import com.zwy.accounting.service.JenkinsService;
import com.zwy.accounting.service.ModuleService;
import com.zwy.accounting.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Afauria on 2019/3/28.
 */
@RestController
@RequestMapping(value = "/api/jenkins")
@CrossOrigin
public class JenkinsController {
    Logger logger = LoggerFactory.getLogger(Logger.class);
//    @Autowired
    private JenkinsService mJenkinsService;
//    @Autowired
    private ModuleService mModuleService;
//    @Autowired
    private ProjectService mProjectService;

    @PostMapping("/notify/module")
    public Result handleMsg(ModuleBuildEntity moduleBuildEntity) {
        logger.info("receive jenkins module notify.");
        mModuleService.handleBuildResult(moduleBuildEntity);
        return ResultUtil.success("handle jenkins message success.");
    }

    @PostMapping("/notify/project")
    public Result handleMsg(ProjectBuildEntity projectBuildEntity) {
        logger.info("receive jenkins project notify");
        mProjectService.handleBuildResult(projectBuildEntity);
        return ResultUtil.success("handle jenkins message success.");
    }
}
