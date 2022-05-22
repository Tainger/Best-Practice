package com.redission.service;

import com.redission.model.entity.User;

public interface UserService {

    User getById(Long userId);
}
