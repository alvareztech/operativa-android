package com.danyalvarez.operationsresearch.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by daniel on 03/03/14.
 */
public class Format {

    public static final String TWO_DECIMALS_NUMBER_FORMAT = "###,###,##0.00";
    public static final String FOUR_DECIMALS_NUMBER_FORMAT = "###,###,##0.0000";
    public static final String WITHOUT_DECIMALS_NUMBER_FORMAT = "###,###,###";

    public static final String DATE_FORMAT = "ddMMMyyyy";
    public static final String DATE_FORMAT_WITH_HOUR = "ddMMMyyyy hh:mm:ss";
    public static final String DATE_FORMAT_WITH_HOUR_MINUTE = "ddMMMyyyy hh:mm";


    public static String date(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(date).toUpperCase();
    }

    public static String dateWithHour(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_WITH_HOUR);
        return simpleDateFormat.format(date).toUpperCase();
    }

    public static String dateWithHourMinute(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_WITH_HOUR_MINUTE);
        return simpleDateFormat.format(date).toUpperCase();
    }

    public static String numberTwoDecimals(double number) {
        DecimalFormat decimalFormat = new DecimalFormat(TWO_DECIMALS_NUMBER_FORMAT);
        decimalFormat.setNegativePrefix("(");
        decimalFormat.setNegativeSuffix(")");
        return decimalFormat.format(number);
    }

    public static String numberFourDecimals(double number) {
        DecimalFormat decimalFormat = new DecimalFormat(FOUR_DECIMALS_NUMBER_FORMAT);
        decimalFormat.setNegativePrefix("(");
        decimalFormat.setNegativeSuffix(")");
        return decimalFormat.format(number);
    }

    public static String numberWithoutDecimals(double number) {
        DecimalFormat decimalFormat = new DecimalFormat(WITHOUT_DECIMALS_NUMBER_FORMAT);
        decimalFormat.setNegativePrefix("(");
        decimalFormat.setNegativeSuffix(")");
        return decimalFormat.format(number);
    }

}
