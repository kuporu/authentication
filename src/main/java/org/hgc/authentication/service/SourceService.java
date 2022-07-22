package org.hgc.authentication.service;

import org.hgc.authentication.pojo.Source;
import org.hgc.authentication.utils.ResponseResult;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public interface SourceService {
    ResponseResult getWeatherId();

    ResponseResult setWeatherId(Source source);
}
