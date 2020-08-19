package com.danyalvarez.operationsresearch.util;

import android.content.Context;
import android.os.Bundle;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Analytics {

    public static void reportModel(String name, Context context) {
        HiAnalyticsTools.enableLog();
        HiAnalyticsInstance instance = HiAnalytics.getInstance(context);

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        bundle.putString("pressTime", sdf.format(new Date()));

        instance.onEvent("Model", bundle);
    }
}
