package org.accp.office.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @create 2019-05-21 20:38
 */
public class OrderUtil {
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }
}
