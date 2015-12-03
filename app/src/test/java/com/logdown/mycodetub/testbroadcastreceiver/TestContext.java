package com.logdown.mycodetub.testbroadcastreceiver;

import android.content.Intent;
import android.test.mock.MockContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pajace on 2015/12/3.
 */

public class TestContext extends MockContext {
    private List<Intent> mReceivedIntents = new ArrayList<>();
    private String packageName;

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void startActivity(Intent intent) {
        mReceivedIntents.add(intent);
    }

    public List<Intent> getReceivedIntents() {
        return mReceivedIntents;
    }
}