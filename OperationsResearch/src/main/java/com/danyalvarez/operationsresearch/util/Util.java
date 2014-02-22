package com.danyalvarez.operationsresearch.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by daniel on 22/02/14.
 */
public class Util {


    public static Bitmap getBitmapFromAsset(Context context, String nameWithExtension) {
        Bitmap bitmap = null;
        AssetManager assetManager = context.getAssets();
        InputStream is;
        try {
            is = assetManager.open(nameWithExtension);
            bitmap = BitmapFactory. decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap getPngBitmapFromAssets(Context context, String name) {
        return getBitmapFromAsset(context, name + ".png");
    }
}
