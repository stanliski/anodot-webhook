package com.netease.anodot.webhook.service.impl;

import com.netease.anodot.webhook.entity.user.UserGroup;
import com.netease.anodot.webhook.repository.UserGroupRepository;
import com.netease.anodot.webhook.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/8/14 16:23.
 *
 * @author Stanley Huang
 */

@Service
public class UserGroupServiceImpl implements UserGroupService {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");

    @Autowired
    private UserGroupRepository repository;

    @Override
    public UserGroup addUserGroup(UserGroup userGroup) {
        userGroup.setCreateTime(df.format(new Date()));
        return repository.insert(userGroup);
    }

    @Override
    public UserGroup updateUserGroup(String id, UserGroup userGroup) {
        UserGroup oldUserGroup = repository.findOne(id);
        oldUserGroup.setEmails(userGroup.getEmails());
        oldUserGroup.setUpdateTime(df.format(new Date()));
        oldUserGroup.setProjectName(userGroup.getProjectName());
        return repository.save(oldUserGroup);
    }

    @Override
    public void deleteUserGroup(UserGroup userGroup) {
        repository.delete(userGroup);
    }

    @Override
    public UserGroup getUserGroup() {
        List<UserGroup> userList = repository.findAll();
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
