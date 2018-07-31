package org.bh.housing.mazaya.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Loay
 *
 */
public class DateConverter {

        public static String prettyTimeStamp(Date date) {
                return new SimpleDateFormat("MM/dd/yyyy HH:mm").format(date);
        }
}
