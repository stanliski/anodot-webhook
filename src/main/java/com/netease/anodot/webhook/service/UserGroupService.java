package com.netease.anodot.webhook.service;

import com.netease.anodot.webhook.entity.user.UserGroup;

/**
 * Created on 2018/8/14 16:23.
 *
 * @author Stanley Huang
 */
public interface UserGroupService {

    UserGroup addUserGroup(UserGroup userGroup);

    UserGroup updateUserGroup(String id, UserGroup userGroup);

    void deleteUserGroup(UserGroup userGroup);

    UserGroup getUserGroup();

}
