package com.netease.anodot.webhook.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class Utils {

    private static final String UTC_FORMAT = "dd/MM/yyyy HH:mm";
    private static final String LOCAL_TIME_FORMAT = "yyyy-MM-dd HH:MM:ss";

    public static String getJSOnStr(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Writer strWriter = new StringWriter();
        mapper.writeValue(strWriter, obj);
        String userDataJSON = strWriter.toString();
        return userDataJSON;
    }

    public static String convertUTCToCST(String utcStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(UTC_FORMAT);
        Date utcDate = sdf.parse(utcStr);
        SimpleDateFormat localFormater = new SimpleDateFormat(LOCAL_TIME_FORMAT);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(utcDate.getTime());
        return localTime;
    }

    public static String newKey(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
        }
        return sb.toString();
    }
}
