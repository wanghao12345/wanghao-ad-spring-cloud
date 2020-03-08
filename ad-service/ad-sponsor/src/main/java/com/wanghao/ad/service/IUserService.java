package com.wanghao.ad.service;

import com.wanghao.ad.exception.AdException;
import com.wanghao.ad.vo.CreateUserRequest;
import com.wanghao.ad.vo.CreateUserResponse;

public interface IUserService {
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
