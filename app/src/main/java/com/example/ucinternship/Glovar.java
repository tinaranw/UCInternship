package com.example.ucinternship;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class Glovar {

    public Glovar(){}

    public static final Dialog loadingDialog(Context context){
        final Dialog dialog = new Dialog(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.loading, null);
        dialog.setContentView(dialogView);
        dialog.setCancelable(false);
        return dialog;
    }

}
