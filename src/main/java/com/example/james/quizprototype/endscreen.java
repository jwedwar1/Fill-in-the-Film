package com.example.james.quizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by James on 9/18/2017.
 */

public class endscreen extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_endscreen);

        TextView total = (TextView)findViewById(R.id.score);
        int right_counter = getIntent().getIntExtra("RIGHT", 0);
        total.setText(String.valueOf(right_counter));

        TextView totalw = (TextView)findViewById(R.id.wrong_score);
        int wrong_counter = getIntent().getIntExtra("WRONG", 0);
        totalw.setText(String.valueOf(wrong_counter));




    }

    public void OnRepeatClick(View view){
        Intent intent = new Intent(this, questions.class);
        startActivity(intent);
        finish();
    }

}
