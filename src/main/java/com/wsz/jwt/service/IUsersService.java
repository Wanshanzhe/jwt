package com.wsz.jwt.service;

import com.wsz.jwt.dao.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanshanzhe
 * @since 2021-04-16
 */
public interface IUsersService extends IService<Users> {

    Users login(Users users);
}
