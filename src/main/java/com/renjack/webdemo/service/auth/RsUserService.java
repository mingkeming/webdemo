package com.renjack.webdemo.service.auth;

import com.renjack.webdemo.entity.auth.RsUser;

import java.util.List;

public interface RsUserService {
    List<RsUser> getUser(RsUser rsUser);

    void insUser(RsUser rsUser);
}
