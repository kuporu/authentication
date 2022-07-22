package org.hgc.authentication.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hgc.authentication.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
