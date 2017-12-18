package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {
    public static final int REQUEST_USERINFO =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);




}
    public void ok(View v) {
        EditText edNickname = (EditText) findViewById(R.id.user_nickname);
        EditText edPhone = (EditText) findViewById(R.id.user_phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EXTRA_phone", phone);
        setResult(RESULT_OK, getIntent());
        Toast.makeText(this,"Nickname:"+nickname, Toast.LENGTH_LONG).show();
        finish();



    }


}