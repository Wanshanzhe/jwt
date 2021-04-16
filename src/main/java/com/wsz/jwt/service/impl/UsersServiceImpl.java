package com.wsz.jwt.service.impl;

import com.wsz.jwt.dao.entity.Users;
import com.wsz.jwt.dao.mapper.UsersMapper;
import com.wsz.jwt.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanshanzhe
 * @since 2021-04-16
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users login(Users users) {
        //根据接受的用户名和密码查询数据库
        Users userDB = usersMapper.login(users);
        if (userDB != null){
            return userDB;
        }else{
            return null;
        }

    }
}
