package com.gary.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by lsx on 2016/7/22.
 */
public class SecondActivity extends AppCompatActivity {

    private TextView mtextView;
    private Button mSendBackButton;
    private EditText mNameEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_activity_layout);

        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        //Log.d("SecondActivity", data);
        //Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();

        mtextView=(TextView)findViewById(R.id.second_activity_view);
        mtextView.setText(data);

        mNameEditText=(EditText) findViewById(R.id.second_activity_edit_text);
        mSendBackButton=(Button)findViewById(R.id.second_activity_button);

        mSendBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name=mNameEditText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("data_return",name);
                setResult(RESULT_OK,intent);
                finish();
            }


        });

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
