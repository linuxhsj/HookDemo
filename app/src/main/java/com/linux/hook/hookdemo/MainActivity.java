package com.linux.hook.hookdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.linux.hook.hookdemo.hook.AMSHookHelper;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.txt)).setText(MainActivity.class.getSimpleName());
        Toast.makeText(this,MainActivity.class.getSimpleName(),Toast.LENGTH_SHORT).show();


        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //启动一个没有在AndroidManifest.xml中声明的Activity
                    startActivity(new Intent(MainActivity.this, TargetActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        AMSHookHelper.hookOnClickListener(button); //都已经可以拿到这个button对象了、那直接修改对应的setOnClickListener方法就好了、还去反射意义在哪里?
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        try {
            AMSHookHelper.hookActivityManagerNative();
            AMSHookHelper.hookActivityThreadHandler();
        } catch (Throwable throwable) {
            throw new RuntimeException("hook failed", throwable);
        }
    }
}
