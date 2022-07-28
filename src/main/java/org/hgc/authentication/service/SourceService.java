package org.hgc.authentication.service;

import org.hgc.authentication.model.Source;
import org.hgc.authentication.model.param.SourceParam;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.stereotype.Service;

@Service
public interface SourceService {
    ResponseResult<String> getWeatherId();

    ResponseResult<String> setWeatherId(SourceParam sourceParam);
}
