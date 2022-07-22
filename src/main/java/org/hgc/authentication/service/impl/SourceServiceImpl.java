package org.hgc.authentication.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.hgc.authentication.mapper.SourceMapper;
import org.hgc.authentication.pojo.Source;
import org.hgc.authentication.service.SourceService;
import org.hgc.authentication.utils.ResponseResult;
import org.hgc.authentication.utils.UserContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class SourceServiceImpl implements SourceService {

    @Resource
    private SourceMapper sourceMapper;

    @Override
    public ResponseResult getWeatherId() {
        LambdaQueryWrapper<Source> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Source::getUserId, UserContext.getCurrentUserId());
        Source source = sourceMapper.selectOne(queryWrapper);

        // 如果查询结果为空，表示之前未登录
        if (Objects.isNull(source)) {
            return new ResponseResult(222, "用户之前未登录");
        } else {
            return ResponseResult.success(source.getWeatherId());
        }
    }

    @Override
    @Transactional
    public ResponseResult setWeatherId(Source source) {
        long currentUserId = UserContext.getCurrentUserId();
        LambdaQueryWrapper<Source> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Source::getUserId, currentUserId);
        Source selectOne = sourceMapper.selectOne(queryWrapper);

        if (!Objects.isNull(selectOne)) {
            sourceMapper.deleteById(selectOne.getId());
        }

        source.setUserId(currentUserId);
        sourceMapper.insert(source);
        return ResponseResult.success("添加记录成功");
    }
}
