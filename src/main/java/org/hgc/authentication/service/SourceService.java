package org.hgc.authentication.service;

import org.hgc.authentication.model.Source;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.stereotype.Service;

@Service
public interface SourceService {
    ResponseResult getWeatherId();

    ResponseResult setWeatherId(Source source);
}
