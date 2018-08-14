package com.netease.anodot.webhook.repository;

import com.netease.anodot.webhook.entity.user.UserGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2018/8/14 16:42.
 *
 * @author Stanley Huang
 */

@Repository
public interface UserGroupRepository extends MongoRepository<UserGroup, String> {
}
