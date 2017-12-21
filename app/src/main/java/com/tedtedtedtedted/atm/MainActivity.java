package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean logon =false;
    public static final int REQUEST_USERINFO =2;
    public static final int REQUEST_LOGIN =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(!logon){
            Intent intent =new Intent(this,LoginActivity.class);
            //startActivity(intent);
            startActivityForResult(intent,REQUEST_LOGIN);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                Intent userinfolayout = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(userinfolayout,REQUEST_USERINFO);

                Snackbar.make(view, "想要顯示的字串", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).setActionTextColor(Color.YELLOW).show();
            }
        });
    }

   /* public void ok(View v) {

        EditText edNickname = (EditText) findViewById(R.id.user_nickname);
        EditText edPhone = (EditText) findViewById(R.id.user_phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EXTRA_phone", phone);
        setResult(RESULT_OK, getIntent());
        Toast.makeText(this,"Nickname:"+nickname, Toast.LENGTH_LONG).show();
        finish();

    }*/



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,  resultCode,  data);
        switch(requestCode){
        case REQUEST_LOGIN:
            if(resultCode==RESULT_OK){
                String uid = data.getStringExtra("EXTRA_USERID");
                String pw = data.getStringExtra("LOGIN_PASSWD");
                Log.d("RESULT", uid + "/////////" + pw);
                Toast.makeText(this,"Login uid:::::"+uid,Toast.LENGTH_LONG).show();
                getSharedPreferences("atm",MODE_PRIVATE)
                        .edit()
                        .putString("USERID",uid)
                        .apply();
               // logon =true;
                Toast.makeText(this,"logon:::::::::::"+logon,Toast.LENGTH_LONG).show();

            }
            else{
                finish();
            }
            break;


            case REQUEST_USERINFO:
                if(resultCode==RESULT_OK){
                    String nickname = data.getStringExtra("EXTRA_NICKNAME");
                    String phone = data.getStringExtra("EXTRA_PHONE");

                    Toast.makeText(this,"Nickname:::::"+nickname,Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"Phone::::::"+phone,Toast.LENGTH_LONG).show();
                    /*getSharedPreferences("atm", MODE_PRIVATE)
                            .edit()
                            .putString("NAME", nickname)
                            .putString("PHONE", phone)
                            .apply();
*/
            }
                else{
                    finish();
                }
           break;







        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
