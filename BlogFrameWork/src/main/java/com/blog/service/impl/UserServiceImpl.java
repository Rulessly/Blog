package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.Vo.UserInfo;
import com.blog.domain.ResponseResult;
import com.blog.domain.User;
import com.blog.service.UserService;
import com.blog.mapper.UserMapper;
import com.blog.utils.BeanCopyUtils;
import com.blog.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
* @author xyxiaobiao
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2022-11-26 17:03:15
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public ResponseResult userInfo() {
        //获取用户当前id
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);
        //封装成userinfovo返回
        UserInfo vo=BeanCopyUtils.copyBean(user, UserInfo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }
}




