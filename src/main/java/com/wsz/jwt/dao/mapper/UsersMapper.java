package com.wsz.jwt.dao.mapper;

import com.wsz.jwt.dao.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanshanzhe
 * @since 2021-04-16
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    Users login(Users users);

}
