package com.example.user.ar3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by user on 2017-06-05.
 */

public class Sub2Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

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
