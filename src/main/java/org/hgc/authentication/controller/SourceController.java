package org.hgc.authentication.controller;

import org.hgc.authentication.model.Source;
import org.hgc.authentication.service.SourceService;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Resource
    private SourceService sourceService;

    @GetMapping("/getWeatherId")
    public ResponseResult getWeatherId () {
        return sourceService.getWeatherId();
    }

    @PostMapping("/setWeatherId")
    public ResponseResult setWeatherId (@RequestBody Source source) {
        return sourceService.setWeatherId(source);
    }
}
