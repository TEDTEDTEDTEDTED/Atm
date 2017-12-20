package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    public static final int REQUEST_USERINFO =2;
    EditText edname;
    EditText edphone;
    Spinner agechoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ArrayList<String> data = new ArrayList<>();
        for(int i=16;i<=40;i++){
            data.add(i+"");
        }
        edname = (EditText) findViewById(R.id.user_nickname);
        edphone = (EditText) findViewById(R.id.user_phone);
        agechoose = (Spinner) findViewById(R.id.sp_age);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        agechoose.setAdapter(adapter);
        edname.setText(getSharedPreferences("atm", MODE_PRIVATE)
                .getString("NAME", ""));
        edphone.setText(getSharedPreferences("atm", MODE_PRIVATE)
                .getString("PHONE", ""));



}
    public void ok(View v) {
        EditText edNickname = (EditText) findViewById(R.id.user_nickname);
        EditText edPhone = (EditText) findViewById(R.id.user_phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        SharedPreferences setting =getSharedPreferences("atm",MODE_PRIVATE);
        setting.edit()
                .putString("NAME", nickname)
                .putString("PHONE", phone)
                .apply();
               // .commit();
        Toast.makeText(this,"Nickname:"+nickname, Toast.LENGTH_LONG).show();
        finish();



    }


}