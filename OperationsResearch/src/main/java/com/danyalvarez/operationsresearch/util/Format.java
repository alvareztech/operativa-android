package com.danyalvarez.operationsresearch.util;

import java.text.DecimalFormat;

public class Format {

    public static final String[] DECIMALS_NUMBER_FORMAT = new String[]{
            "###,###,###,###",
            "###,###,###,##0.0",
            "###,###,###,##0.00",
            "###,###,###,##0.000",
            "###,###,###,##0.0000",
            "###,###,###,##0.00000"
    };

    public static String number(double number, int decimalNumber) {
        if (decimalNumber < 0 || decimalNumber > 5) {
            return "";
        }
        DecimalFormat decimalFormat = new DecimalFormat(DECIMALS_NUMBER_FORMAT[decimalNumber]);
        decimalFormat.setNegativePrefix("(");
        decimalFormat.setNegativeSuffix(")");
        return decimalFormat.format(number);
    }

}
