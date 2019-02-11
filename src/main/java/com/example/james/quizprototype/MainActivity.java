package com.example.james.quizprototype;
import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page1);
    }

    public void onSplashPageClick(View view){
        Intent intent = new Intent(this, questions.class);
        startActivity(intent);
        finish();
    }
}
