package com.netease.anodot.webhook.repository;

import com.netease.anodot.webhook.entity.TopEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2018/8/13 10:45.
 *
 * @author Stanley Huang
 */

@Repository
public interface TopEventRepository extends MongoRepository<TopEvent, String> {
}
