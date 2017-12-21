package com.tedtedtedtedted.atm;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private EditText edDate;
    private EditText edInfo;
    private EditText edAmount;
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        helper =new MyDBHelper(this,"expense.db",null,1);



    }

    public void findviews(){

        edDate=(EditText)findViewById(R.id.ed_date);
        edInfo=(EditText)findViewById(R.id.ed_info);
        edAmount=(EditText)findViewById(R.id.ed_amount);
    }

    public void add(View v){
       String cdate = edDate.getText().toString();
       String info = edInfo.getText().toString();
       int amount =Integer.parseInt(edAmount.getText().toString());
        ContentValues values =new ContentValues();
       values.put("cdate",cdate);
        values.put("into",info);
        values.put("into",amount);
        long id =helper.getWritableDatabase().insert("exp",null,values);
        Log.d("ADD",id+"");
    }

}
