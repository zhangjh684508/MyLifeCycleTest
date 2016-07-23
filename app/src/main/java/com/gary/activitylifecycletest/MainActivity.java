package com.gary.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Log.d(TAG,"onCreate: zhixing le");

        Button button=(Button)findViewById(R.id.activity_main_button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(MainActivity.this, "button clicked", Toast.LENGTH_SHORT).show();

                    /*
                    String data="Hello SecondActivity";
                    Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("extra_data", data);
                    startActivity(intent);
                    */

                    Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                    //startActivityForResult(intent, 1);

                    EditText editText=(EditText)findViewById(R.id.activity_main_edit);
                    intent.putExtra("extra_data",editText.getText().toString());
                    startActivityForResult(intent, 0);
            }
        }
        );

        Button ThirdButton=(Button)findViewById(R.id.activity_main_Thirdbutton);
        ThirdButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String returnedData=null;

        switch (requestCode)
        {
            case 0:
                if (resultCode==RESULT_OK)
                {
                    returnedData=data.getStringExtra("data_return");
                }
                break;

            case 1:
                if (resultCode==RESULT_OK)
                {
                    returnedData=data.getStringExtra("data_return_third");
                }
                break;

        }

        EditText editText=(EditText)findViewById(R.id.activity_main_edit);
        editText.setText(returnedData);


    }


    @Override
    protected void onStart() {
        super.onStart();
        //Log.d(TAG, "onStart: zhixing le");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.d(TAG, "onResume: zhixing le ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.d(TAG, "onPause: ok");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Log.d(TAG, "onStop: ok");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.d(TAG, "onDestroy: ok");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Log.d(TAG, "onRestart: ok");
    }
}
