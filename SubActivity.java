package com.example.user.ar3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by user on 2017-06-05.
 */

public class SubActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override public void onClick(View v)
            {
                Intent i1 = new Intent(SubActivity.this, Sub2Activity.class);
                startActivity(i1);
            }
                                  });
        Toast.makeText(this, "[B] onCreate() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        Toast.makeText(this, "[B] onStart() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onRestart()
    {
        super.onRestart();

        Toast.makeText(this, "[B] onRestart() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onResume()
    {
        super.onResume();

        Toast.makeText(this, "[B] onResume() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onPause()
    {
        super.onPause();

        Toast.makeText(this, "[B] onPause() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        Toast.makeText(this, "[B] onStop() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        Toast.makeText(this, "[B] onDestroy() 함수 호출", Toast.LENGTH_SHORT).show();
    }
}
