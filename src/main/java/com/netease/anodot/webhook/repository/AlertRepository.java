package com.netease.anodot.webhook.repository;

import com.netease.anodot.webhook.entity.BaseAlert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2018/8/10 12:41.
 *
 * @author Stanley Huang
 */

@Repository
public interface AlertRepository extends MongoRepository<BaseAlert, String> {

}
