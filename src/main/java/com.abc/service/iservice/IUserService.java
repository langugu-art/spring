package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.User;

public interface IUserService {
    //定义方法，设置返回值
    Res userExist(String username);

    Res<User> login(User user);
}
