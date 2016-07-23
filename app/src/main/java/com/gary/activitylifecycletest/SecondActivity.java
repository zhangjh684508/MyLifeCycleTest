package com.gary.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lsx on 2016/7/22.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        //Log.d("SecondActivity", data);
        Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
