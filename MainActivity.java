package com.example.user.ar3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity implements
            AdapterView.OnItemSelectedListener
    {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button = (Button)this.findViewById(R.id.getbutton);
            button.setOnClickListener(new Button.OnClickListener(){
                    @Override public void onClick(View v)
                {
                    Intent i = new Intent(MainActivity.this, SubActivity.class);
                    startActivity(i);
                }
                                      });
            Spinner spinner = (Spinner)this.findViewById(R.id.spinnerid);
            spinner.setOnItemSelectedListener(this);
        }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id)
    {
        String number = null;
        String[] numberArray =
                getResources().getStringArray(R.array.number_array);
        number = numberArray[position];

        TextView selectNumber = (TextView)this.findViewById(R.id.selectnumber);
        selectNumber.setText(number);
    }


    public void onNothingSelected(AdapterView<?> parent)
    {
        ;
    }
}
