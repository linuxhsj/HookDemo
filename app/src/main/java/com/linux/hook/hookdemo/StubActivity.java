package com.linux.hook.hookdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.txt)).setText(StubActivity.class.getSimpleName());

        Toast.makeText(this,StubActivity.class.getSimpleName(),Toast.LENGTH_SHORT).show();
    }
}
