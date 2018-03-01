package com.linux.hook.hookdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TargetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        ((TextView) findViewById(R.id.txt)).setText(TargetActivity.class.getSimpleName());

        Toast.makeText(this,TargetActivity.class.getSimpleName(),Toast.LENGTH_SHORT).show();
    }
}
