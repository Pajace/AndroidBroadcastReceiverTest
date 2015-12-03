package com.logdown.mycodetub.testbroadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.logdown.mycodetub.testbroadcastreceiver.receiver.MySecretReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();
    }

    private void initButton() {
        Button button = (Button) findViewById(R.id.test_broadcast_intent_button);
        button.setText("Broadcast Intent");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MySecretReceiver.ACTION_MY_TEST_SECRET_INTENT);
                intent.putExtra(MySecretReceiver.KEY_OF_SECRET_TEST_NUMBER, "+886912345678");

                sendBroadcast(intent);
            }
        });
    }
}
