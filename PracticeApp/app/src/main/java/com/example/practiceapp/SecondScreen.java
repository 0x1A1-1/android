package com.example.practiceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by cigarent on 6/11/16.
 */
public class SecondScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("CallingActivity");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);

        callingActivityMessage.setText("Called From "+previousActivity);
    }

    public void onSendUserName(View view) {
        EditText showNameET = (EditText) findViewById(R.id.user_name_edit_text);
        EditText showIntroET = (EditText) findViewById(R.id.show_intro);

        String intro = showIntroET.getText().toString();
        String showName = showNameET.getText().toString();

        Show newshow = new Show(showName,intro);

        Intent goBack = new Intent();

        goBack.putExtra("Name",newshow);

        setResult(RESULT_OK, goBack);

        finish();
    }


}
