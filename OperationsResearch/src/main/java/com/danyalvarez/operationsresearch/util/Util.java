package com.danyalvarez.operationsresearch.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;

import com.danyalvarez.operationsresearch.R;

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


    public static void showErrorMessage(FragmentActivity activity, int message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.error_calculating);
        builder.setMessage(message);
        builder.setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }
}
