package com.ivianuu.toasty.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ivianuu.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // normally you would do this in your application class
        Toasty.init(this);

        Toasty.error("Error");

        Toasty.info(R.string.app_name);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Toasty.warning("Wuh");
            }
        }).start();
    }
}
