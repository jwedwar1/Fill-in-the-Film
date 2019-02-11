package com.example.james.quizprototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class questions extends AppCompatActivity {

    private boolean done;
    private int questionNum;
    private Random rand = new Random();
    private int randNum = rand.nextInt(50);
    private int randNum_ans = randNum;
    public int right_counter = 0;
    private int wrong_counter = 0;
    private int skip_counter;
    private int total_counter;
    public int finalscore;

    public static int fscore;

    private ArrayList<Integer> movieList = new ArrayList<Integer>(Arrays.asList(R.drawable.alien, R.drawable.amadeus, R.drawable.animal_house, R.drawable.apocalypse_now, R.drawable.apocalypto,
            R.drawable.back_to_the_future, R.drawable.back_to_the_future_ii, R.drawable.back_to_the_future_iii, R.drawable.beetlejuice, R.drawable.blade_runner,
            R.drawable.brazil, R.drawable.candyman, R.drawable.dark_city, R.drawable.diamonds_are_forever, R.drawable.dirty_harry,
            R.drawable.dirty_rotten_scoundrels, R.drawable.dogma, R.drawable.drag_me_to_hell, R.drawable.enemy, R.drawable.enter_the_dragon,
            R.drawable.escape_from_new_york, R.drawable.fear_and_loathing_in_las_vegas, R.drawable.gremlins, R.drawable.halloween_ii, R.drawable.hook,
            R.drawable.inglorious_basterds, R.drawable.inherent_vice, R.drawable.interstellar,
            R.drawable.it_follows, R.drawable.jaws, R.drawable.killer_klowns_from_outer_space, R.drawable.labyrinth, R.drawable.last_action_hero,
            R.drawable.legend, R.drawable.leon, R.drawable.live_and_let_die, R.drawable.mad_max_beyond_thunderdome, R.drawable.masters_of_the_universe,
            R.drawable.moonraker, R.drawable.raiders_of_the_lost_ark, R.drawable.the_bodyguard, R.drawable.the_exorcist, R.drawable.the_fog,
            R.drawable.the_frightners, R.drawable.the_godfather, R.drawable.the_goonies, R.drawable.the_grand_budapest_hotel, R.drawable.trouble_in_little_china,
            R.drawable.the_thing, R.drawable.robocop, R.drawable.the_neverending_story));

    private ArrayList<String> questionList = new ArrayList<String>(Arrays.asList("Alien", "Amadeus", "Animal House", "Apocalypse Now", "Apocalypto", "Back to the Future",
            "Back to the Future II", "Back to the Future III", "Beetlejuice", "Blade Runner", "Brazil", "Candyman", "Dark City", "Diamonds are Forever", "Dirty Harry",
            "Dirty Rotten Scoundrels", "Dogma", "Drag Me to Hell", "Enemy", "Enter the Dragon", "Escape from New York", "Fear and Loathing in Las Vegas", "Gremlins",
            "Halloween II", "Hook", "Inglorious Basterds", "Inherent Vice", "Interstellar",
            "It Follows", "Jaws", "Killer Klowns from Outer Space", "Labyrinth", "Last Action Hero", "Legend", "Leon", "Live and Let Die", "Mad Max Beyond Thunderdome",
            "Masters of the Universe", "Moonraker", "Raiders of the Lost Ark", "The Bodyguard", "The Exorcist", "The Fog", "The Frighteners", "The Godfather", "The Goonies",
            "The Grand Budapest Hotel", "Big Trouble in Little China", "The Thing", "Robocop", "The Neverending Story"));

    private ArrayList<String> answerList = new ArrayList<String>(Arrays.asList("alien", "amadeus", "animal house", "apocalypse now", "apocalypto", "back to the future",
            "back to the future ii", "back to the future iii", "beetlejuice", "blade runner", "brazil", "candyman", "dark city", "diamonds are forever", "dirty harry",
            "dirty rotten scoundrels", "dogma", "drag me to hell", "enemy", "enter the dragon", "escape from new york", "fear and loathing in las vegas", "gremlins",
            "halloween ii", "hook", "inglorious basterds", "inherent vice", "interstellar",
            "it follows", "jaws", "killer klowns from outer space", "labyrinth", "last action hero", "legend", "leon", "live and let die", "mad max beyond thunderdome",
            "masters of the universe", "moonraker", "raiders of the lost ark", "the bodyguard", "the exorcist", "the fog", "the frighteners", "the godfather", "the goonies",
            "the grand budapest hotel", "big trouble in little china", "the thing", "robocop", "the neverending story"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        ImageView i = (ImageView) findViewById(R.id.movie);
        i.setImageDrawable(getDrawable(movieList.get(randNum)));
        TextView t = (TextView) findViewById(R.id.question);
        TextView score = (TextView) findViewById(R.id.right_counter);
        score.setText(String.valueOf(right_counter));
        t.setText(questionList.get(randNum));
        findViewById(R.id.correctornot).setVisibility(View.INVISIBLE);
        findViewById(R.id.nextbutton).setVisibility(View.INVISIBLE);

    }

    public void onSkipClick(View view){
        done = true;
        if (done){

            String[] questions = getResources().getStringArray(R.array.Questions);
            if(questionNum < (questions.length - 1)) {
                TextView t = (TextView) findViewById(R.id.question);
                // delete the used index from all 3 arrays
                movieList.remove(randNum);
                questionList.remove(randNum);
                answerList.remove(randNum);
                if(movieList.size() == 41){
                    // check if 50 have gone by
                    Intent intent = new Intent(this, endscreen.class);
                    startActivity(intent);
                    finish();

                    Intent score = new Intent(getApplicationContext(), endscreen.class);
                    intent.putExtra("RIGHT", right_counter);
                    startActivity(intent);

                    Intent wrong_score = new Intent(getApplicationContext(), endscreen.class);
                    intent.putExtra("WRONG", wrong_counter);
                    startActivity(intent);
                }
                randNum = rand.nextInt(movieList.size());
                randNum_ans = randNum;
                t.setText(questionList.get(randNum));
                ImageView i = (ImageView) findViewById(R.id.movie);
                i.setImageDrawable(getDrawable(movieList.get(randNum)));
                findViewById(R.id.correctornot).setVisibility(View.INVISIBLE);
                findViewById(R.id.nextbutton).setVisibility(View.INVISIBLE);
                EditText et = (EditText) findViewById(R.id.answer);
                et.setText("");

                skip_counter++;

                done = false;
            }
        }
    }

    public void onAnswerClick(View view) {
        Button submit_btn = (Button) findViewById(R.id.submit_button);
        Button skip_btn = (Button) findViewById(R.id.skip_button);
        skip_btn.setEnabled(false);
        submit_btn.setEnabled(false);
        if (done == false) {

            String answer = ((EditText) findViewById(R.id.answer)).getText().toString();
            String correctanswer = answerList.get(randNum_ans);
            answer = answer.toLowerCase();

            if (answer.equals(correctanswer)) {
                TextView t = (TextView) findViewById(R.id.correctornot);
                t.setText("CORRECT!");
                right_counter++;
                TextView score = (TextView) findViewById(R.id.right_counter);
                score.setText(String.valueOf(right_counter));
                answersubmitted();
            } else {
                wrong_counter++;
                TextView t = (TextView) findViewById(R.id.correctornot);
                t.setText(questionList.get(randNum));

                answersubmitted();
            }
            done = true;
            findViewById(R.id.nextbutton).setVisibility(View.VISIBLE);
            findViewById(R.id.correctornot).setVisibility(View.VISIBLE);
        }
    }

    public void onNextClick(View view){
        Button submit_btn = (Button) findViewById(R.id.submit_button);
        Button skip_btn = (Button) findViewById(R.id.skip_button);
        skip_btn.setEnabled(true);
        submit_btn.setEnabled(true);
        if (done){

            String[] questions = getResources().getStringArray(R.array.Questions);
            if(questionNum < (questions.length - 1)) {
                TextView t = (TextView) findViewById(R.id.question);
                // delete the used index from all 3 arrays
                movieList.remove(randNum);
                questionList.remove(randNum);
                answerList.remove(randNum);
                if(movieList.size() == 41){
                    // check if 50 have gone by
                    fscore = right_counter;
                    Intent intent = new Intent(this, endscreen.class);
                    startActivity(intent);
                    finish();
                    Intent score = new Intent(getApplicationContext(), endscreen.class);
                    intent.putExtra("RIGHT", right_counter);
                    startActivity(intent);

                    Intent wrong_score = new Intent(getApplicationContext(), endscreen.class);
                    intent.putExtra("WRONG", wrong_counter);
                    startActivity(intent);
                }
                randNum = rand.nextInt(movieList.size());
                randNum_ans = randNum;
                t.setText(questionList.get(randNum));
                ImageView i = (ImageView) findViewById(R.id.movie);
                i.setImageDrawable(getDrawable(movieList.get(randNum)));
                findViewById(R.id.correctornot).setVisibility(View.INVISIBLE);
                findViewById(R.id.nextbutton).setVisibility(View.INVISIBLE);
                EditText et = (EditText) findViewById(R.id.answer);
                et.setText("");

                total_counter++;
                done = false;
            }
        }
    }

    public void answersubmitted(){
        TranslateAnimation animation = new TranslateAnimation(0,0,2000,0);
        animation.setDuration(0000);
        animation.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation){
            }
            @Override
            public void onAnimationEnd(Animation animation){
                findViewById(R.id.correctornot).setVisibility(View.VISIBLE);
                findViewById(R.id.nextbutton).setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation){
            }
        });
    }

}
