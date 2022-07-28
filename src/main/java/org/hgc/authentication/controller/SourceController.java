package org.hgc.authentication.controller;

import org.hgc.authentication.model.Source;
import org.hgc.authentication.model.param.SourceParam;
import org.hgc.authentication.service.SourceService;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Resource
    private SourceService sourceService;

    /**
     * 获取用户对应的Weather_id
     * @return
     */
    @GetMapping("/getWeatherId")
    public ResponseResult<String> getWeatherId () {
        return sourceService.getWeatherId();
    }

    /**
     * 添加用户对应的Weather_id
     * @param sourceParam
     * @return
     */
    @PostMapping("/setWeatherId")
    public ResponseResult<String> setWeatherId (@RequestBody @Valid SourceParam sourceParam) {
        return sourceService.setWeatherId(sourceParam);
    }
}
