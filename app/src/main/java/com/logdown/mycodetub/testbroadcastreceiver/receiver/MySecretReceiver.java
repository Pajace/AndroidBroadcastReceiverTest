package com.logdown.mycodetub.testbroadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.logdown.mycodetub.testbroadcastreceiver.view.SecretActivity;

public class MySecretReceiver extends BroadcastReceiver {

    public static final String ACTION_MY_TEST_SECRET_INTENT = "com.logdown.mycodetub.testreceiver";
    public static final String KEY_OF_SECRET_TEST_NUMBER = "KEY_SECRET_NUMBER";

    public MySecretReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(ACTION_MY_TEST_SECRET_INTENT)) {
            String secretNumber = intent.getStringExtra(KEY_OF_SECRET_TEST_NUMBER);

            Intent myIntent = new Intent();
            myIntent.setClass(context, SecretActivity.class);
            myIntent.putExtra(KEY_OF_SECRET_TEST_NUMBER, secretNumber);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(myIntent);
            setResultData(null);
        }
    }
}
