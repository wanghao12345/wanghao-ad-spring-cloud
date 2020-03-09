package com.wanghao.ad.utils;


import com.wanghao.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class CommonUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd"
    };

    /**
     * 生成md5(token)
     */
    public static String md5(String value) {
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    public static Date parseStringDate(String dateString) throws AdException {
        try {
            return DateUtils.parseDate(
                    dateString, parsePatterns
            );
        } catch (Exception e) {
            throw new AdException(e.getMessage());
        }
    }
}
