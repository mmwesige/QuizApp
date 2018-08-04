package com.example.moses.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Global Variable
    String Q4 = "California";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method to mark questions and display score
     */

    public void markQuestions(View view) {

        //Checks whether Question 1 is correct
        RadioButton question1 = (RadioButton) findViewById(R.id.option_1b);
        boolean selected1b = question1.isChecked();

        //Checks whether Question 2 is correct
        RadioButton question2 = (RadioButton) findViewById(R.id.option_2a);
        boolean selected2a = question2.isChecked();

        //Checks whether Question 3 is correct
        RadioButton question3 = (RadioButton) findViewById(R.id.option_3b);
        boolean selected3b = question3.isChecked();

        //Checks whether Question 4 is correct
        EditText question4 = findViewById(R.id.option4);
        String state = question4.getText().toString();

        //Checks whether Question 5 is correct
        CheckBox question5a = (CheckBox) findViewById(R.id.option_5a);
        boolean selected5a = question5a.isChecked();
        CheckBox question5b = (CheckBox) findViewById(R.id.option_5b);
        boolean selected5b = question5b.isChecked();
        CheckBox question5c = (CheckBox) findViewById(R.id.option_5c);
        boolean selected5c = question5c.isChecked();

        int score = calculateScore(selected1b, selected2a, selected3b, state, selected5a, selected5b, selected5c);
        String finalScore = Integer.toString(score);
        displayMessage("Your Final Score is: " + finalScore + "/50");
    }

    /**
     * Calculates the Marks for the Quiz
     *
     * @return the total score
     */
    private int calculateScore(boolean question1, boolean question2, boolean question3, String question4, boolean question5a, boolean question5b, boolean question5c) {
        //Initial Score
        int baseScore = 0;

        // Add 10 marks if answer is correct
        if (question1) {
            baseScore += 10;
        }

        // Add 10 marks if answer is correct
        if (question2) {
            baseScore += 10;
        }

        // Add 10 marks if answer is correct
        if (question3) {
            baseScore += 10;
        }

        // Add 10 marks if answer is correct
        if (question4.equals(Q4)) {
            baseScore += 10;
        }

        // Add 10 marks if answer is correct
        if (question5a && question5b && question5c) {
            baseScore += 10;
        }

        //Calculate and return the total order price
        return baseScore;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }
}
