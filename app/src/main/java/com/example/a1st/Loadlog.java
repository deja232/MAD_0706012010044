package com.example.a1st;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loadlog {
    private Activity activity;
    private AlertDialog dialog;

    Loadlog(Activity aktif){
        activity = aktif;
    }
    void dialogalert(){
        AlertDialog.Builder build = new AlertDialog.Builder(activity);

        LayoutInflater inflater =   activity.getLayoutInflater();
        build.setView(inflater.inflate(R.layout.activity_loading, null));
        build.setCancelable(false);

        dialog = build.create();
        dialog.show();
    }
    void gone(){
        dialog.dismiss();
    }
}
