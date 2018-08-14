package com.netease.anodot.webhook.controller;

import com.netease.anodot.webhook.entity.ResponseContent;
import com.netease.anodot.webhook.entity.anomaly.AnomalyAlert;
import com.netease.anodot.webhook.entity.nodata.NoDataAlert;
import com.netease.anodot.webhook.entity.staticAlert.StaticAlert;
import com.netease.anodot.webhook.integrations.MailChimp;

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

    private MailChimp mailChimp;

    @Autowired
    public WebhookController(
            AlertService alertService,
            MailChimp mailChimp) {
        this.mailChimp = mailChimp;
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
        StaticAlert newAlert = (StaticAlert) alertService.addAlert(alert);
        return new ResponseContent<>(true, true, "");
    }

//    @RequestMapping(
//            value = "/3scaleToMailChimp",
//            method = RequestMethod.POST,
//            produces = {MediaType.TEXT_PLAIN_VALUE},
//            consumes = {MediaType.APPLICATION_XML_VALUE})
//    public String process3ScaleToMailChimp(@RequestBody(required = true) String threeScaleRequest) {
//        long startTime = System.currentTimeMillis();
//        try {
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
//            InputSource is = new InputSource();
//            is.setCharacterStream(new StringReader(threeScaleRequest));
//            Document xmlDom = docBuilder.parse(is);
//            String orgName = null;
//            String email = null;
//            if (null != xmlDom) {
//                Element eventNode = xmlDom.getDocumentElement();
//                Element objectNode = DomUtils.getChildElementByTagName(eventNode, "object");
//                if (null != objectNode) {
//                    Element accountNode = DomUtils.getChildElementByTagName(objectNode, "account");
//                    if (null != accountNode) {
//                        Element orgNameNode = DomUtils.getChildElementByTagName(accountNode, "org_name");
//                        orgName = DomUtils.getTextValue(orgNameNode);
//                    }
//                    Element usersNode = DomUtils.getChildElementByTagName(accountNode, "users");
//                    if (null != usersNode) {
//                        Element userNode = DomUtils.getChildElementByTagName(usersNode, "user");
//                        email = DomUtils.getChildElementValueByTagName(userNode, "email");
//                    }
//                }
//            }
//
//            if (null != orgName && null != email) {
//                String response = this.mailChimp.addNewMemberToList(email, orgName, "", "");
//                //return response;
//            } else {
//                throw new Exception("Something wrong in parsing XML request and getting values");
//            }
//        } catch (Exception ex) {
//            this.logger.error("3ScaleToMailChimp : Caught exception at rest controller.", ex);
//            return "FAIL";
//        }
//
//        long endTime = System.currentTimeMillis();
//        String responseTime = (endTime - startTime) + " msecs";
//        this.logger.info("Time took for server to process this request is " + responseTime);
//        return "SUCCESS";
//    }

}
