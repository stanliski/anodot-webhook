package com.netease.anodot.webhook.controller;

import com.netease.anodot.webhook.entity.ResponseContent;
import com.netease.anodot.webhook.entity.user.UserGroup;
import com.netease.anodot.webhook.service.UserGroupService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created on 2018/8/14 16:51.
 *
 * @author Stanley Huang
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserGroupController {
    private static final Logger logger = LoggerFactory.getLogger(UserGroupController.class);
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");

    @Autowired
    private UserGroupService userGroupService;

    @ApiOperation(value = "添加一个用户组", notes = "添加一个用户组")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseContent<UserGroup> addUserGroup(@RequestBody UserGroup userGroup) {
        UserGroup newUserGroup = userGroupService.addUserGroup(userGroup);
        return new ResponseContent<>(true, newUserGroup, "");
    }

    @ApiOperation(value = "更新用户组", notes = "更新用户组")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseContent<UserGroup> updateUserGroup(
            @PathVariable String id,
            @RequestBody UserGroup userGroup) {
        UserGroup newUserGroup = userGroupService.updateUserGroup(id, userGroup);
        return new ResponseContent<>(true, newUserGroup, "");
    }

}
