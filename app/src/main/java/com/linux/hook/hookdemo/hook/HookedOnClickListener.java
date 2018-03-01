package com.linux.hook.hookdemo.hook;

import android.util.Log;
import android.view.View;

class HookedOnClickListener implements View.OnClickListener {
        private View.OnClickListener origin;

        HookedOnClickListener(View.OnClickListener origin) {
            this.origin = origin;
        }

        @Override
        public void onClick(View v) {
            Log.e("HookedOnClickListener","Before click, do what you want to to.");
            if (origin != null) {
                origin.onClick(v);
            }
            Log.e("HookedOnClickListener","After click, do what you want to to.");
        }
    }

/*
作者：落英坠露
链接：https://www.jianshu.com/p/4f6d20076922
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
