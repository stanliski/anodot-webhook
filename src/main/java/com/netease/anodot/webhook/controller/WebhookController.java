package com.netease.anodot.webhook.controller;

import com.netease.anodot.webhook.entity.AlertType;
import com.netease.anodot.webhook.entity.ResponseContent;
import com.netease.anodot.webhook.entity.anomaly.AnomalyAlert;
import com.netease.anodot.webhook.entity.nodata.NoDataAlert;
import com.netease.anodot.webhook.entity.staticAlert.StaticAlert;

import com.netease.anodot.webhook.service.AlertService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/alert")
public class WebhookController {
    private static final Log logger = LogFactory.getLog(WebhookController.class);

    private AlertService alertService;

    @Autowired
    public WebhookController(AlertService alertService) {
        this.alertService = alertService;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "webhook_pong";
    }

    @RequestMapping(value = "/3scaleToMailChimp", method = RequestMethod.GET)
    public String ping2() {
        return "webhook_pong";
    }


    @ApiOperation(value = "Anomoly event webhook接口", notes = "Anomoly event webhook接口")
    @RequestMapping(value = "/anomaly",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseContent<Boolean> getAnomolyAlert(@RequestBody AnomalyAlert alert) {
        logger.info("Add new alert = " + alert.toString());
        alert.setAlertType(AlertType.ANOMALY);
        AnomalyAlert newAlert = (AnomalyAlert) alertService.addAlert(alert);
        return new ResponseContent<>(true, true, "");
    }

    @ApiOperation(value = "No data event webhook接口", notes = "No data event webhook接口")
    @RequestMapping(value = "/nodata",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseContent<Boolean> getNoDataAlert(@RequestBody NoDataAlert alert) {
        logger.info("Add new alert = " + alert.toString());
        alert.setAlertType(AlertType.NO_DATA);
        NoDataAlert newAlert = (NoDataAlert) alertService.addAlert(alert);
        return new ResponseContent<>(true, true, "");
    }

    @ApiOperation(value = "Static event webhook接口", notes = "Static event webhook接口")
    @RequestMapping(value = "/static",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseContent<Boolean> getStaticAlert(@RequestBody StaticAlert alert) {
        logger.info("Add new alert = " + alert.toString());
        alert.setAlertType(AlertType.STATIC);
        StaticAlert newAlert = (StaticAlert) alertService.addAlert(alert);
        return new ResponseContent<>(true, true, "");
    }

}
