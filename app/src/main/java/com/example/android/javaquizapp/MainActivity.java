package com.example.android.javaquizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float pointsTotal=0;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Processes answers after Submit Button is clicked.
     * <p>
     * Or returns state to the View as it was before user input.
     */
    public void checkQuestions(View view){
        Button submitButton = (Button) findViewById(R.id.submit_button);
        if (submitButton.getText().toString().equalsIgnoreCase("Submit") == true) {
            submitButton.setText(R.string.reset);

            checkFirstQuestion();
            checkSecondQuestion();
            checkThirdQuestion();
            checkForthQuestion();

            Toast.makeText(getApplicationContext(), getText(R.string.total_points) + " " + Float.toString(pointsTotal), Toast.LENGTH_LONG).show();
        }
        else {
            pointsTotal = 0;
            submitButton.setText(R.string.submit);

            refresh();


            }
    }

    /**
     * Refreshes the View
     */
    private void refresh(){
        //First question
        CheckBox cb1 = (CheckBox) findViewById(R.id.q1_1_cb);
        cb1.setClickable(true);
        cb1.setChecked(false);
        cb1.setBackgroundColor(0x00000000);


        CheckBox cb2 = (CheckBox) findViewById(R.id.q1_2_cb);
        cb2.setClickable(true);
        cb2.setChecked(false);
        cb2.setBackgroundColor(0x00000000);

        CheckBox cb3 = (CheckBox) findViewById(R.id.q1_3_cb);
        cb3.setClickable(true);
        cb3.setChecked(false);
        cb3.setBackgroundColor(0x00000000);

        CheckBox cb4 = (CheckBox) findViewById(R.id.q1_4_cb);
        cb4.setClickable(true);
        cb4.setChecked(false);
        cb4.setBackgroundColor(0x00000000);

        CheckBox cb5 = (CheckBox) findViewById(R.id.q1_5_cb);
        cb5.setClickable(true);
        cb5.setChecked(false);
        cb5.setBackgroundColor(0x00000000);



        LinearLayout firstLinearLayout = (LinearLayout) findViewById(R.id.q1_ll);
        firstLinearLayout.setBackgroundColor(0x00000000);

        TextView firstPointsTV = (TextView) findViewById(R.id.points1_text_view);
        firstPointsTV.setVisibility(View.INVISIBLE);

        //Second question
        EditText missingET = (EditText) findViewById(R.id.missing_word_edit_text);
        missingET.setClickable(true);
        missingET.setCursorVisible(true);
        missingET.setFocusable(true);
        missingET.setFocusableInTouchMode(true);
        missingET.setText("");

        LinearLayout secondLinearLayout = (LinearLayout) findViewById(R.id.q2_ll);
        secondLinearLayout.setBackgroundColor(0x00000000);

        TextView secondPointsTV = (TextView) findViewById(R.id.points2_text_view);
        secondPointsTV.setVisibility(View.INVISIBLE);

        //Third question
        RadioButton yesRB = (RadioButton) findViewById(R.id.q3_yes_radio_button);
        yesRB.setClickable(true);
        yesRB.setChecked(false);

        RadioButton noRB = (RadioButton) findViewById(R.id.q3_no_radio_button);
        noRB.setClickable(true);
        noRB.setChecked(false);

        LinearLayout thirdLinearLayout = (LinearLayout) findViewById(R.id.q3_ll);
        thirdLinearLayout.setBackgroundColor(0x00000000);

        TextView thirdPointsTV = (TextView) findViewById(R.id.points3_text_view);
        thirdPointsTV.setVisibility(View.INVISIBLE);

        //Forth question
        RadioButton q41RB = (RadioButton) findViewById(R.id.q4_1_radio_button);
        q41RB.setClickable(true);
        q41RB.setChecked(false);

        RadioButton q42RB = (RadioButton) findViewById(R.id.q4_2_radio_button);
        q42RB.setClickable(true);
        q42RB.setChecked(false);

        RadioButton q43RB = (RadioButton) findViewById(R.id.q4_3_radio_button);
        q43RB.setClickable(true);
        q43RB.setChecked(false);

        RadioButton q44RB = (RadioButton) findViewById(R.id.q4_4_radio_button);
        q44RB.setClickable(true);
        q44RB.setChecked(false);


        LinearLayout forthLinearLayout = (LinearLayout) findViewById(R.id.q4_ll);
        forthLinearLayout.setBackgroundColor(0x00000000);

        TextView forthPointsTV = (TextView) findViewById(R.id.points4_text_view);
        forthPointsTV.setVisibility(View.INVISIBLE);
    }


    /**
     * Sets Background Color to a LinearLayout depending on a quantity of points
     * @param points a quantity of points in a block of question
     * @param currentLL a LinearLayout in which block of question is positioned
     */
    private void checkPoints(float points, LinearLayout currentLL){
     if(points == 1)
         currentLL.setBackgroundColor(Color.parseColor("#ff99cc00")); //holo_green_light
        else if (points == 0)
            currentLL.setBackgroundColor(Color.parseColor("#D32F2F")); //red #FF0000 #F44336 #D32F2F
        else currentLL.setBackgroundColor(Color.parseColor("#FFCA28")); //yellow
    }

    /**
     * Displays a quantity of points in a selected TextView.
     * @param pointsTV a TextView in which quantity of points will be displayed
     * @param points a quantity of points which will be displayed in the TextView
     */
    private void showPoints(TextView pointsTV, float points){
        pointsTV.setVisibility(View.VISIBLE);
        pointsTV.setText(getString(R.string.points) + " " + Float.toString(points));
    }


    /**
     * Checks first question.
     */
    private void checkFirstQuestion(){
        float points = 0;
        float taskCost = (float) 0.2;

        CheckBox cb1 = (CheckBox) findViewById(R.id.q1_1_cb);
        points = checkCB(points, taskCost, cb1, true);

        CheckBox cb2 = (CheckBox) findViewById(R.id.q1_2_cb);
        points = checkCB(points, taskCost, cb2, false);

        CheckBox cb3 = (CheckBox) findViewById(R.id.q1_3_cb);
        points = checkCB(points, taskCost, cb3, true);

        CheckBox cb4 = (CheckBox) findViewById(R.id.q1_4_cb);
        points = checkCB(points, taskCost, cb4, false);

        CheckBox cb5 = (CheckBox) findViewById(R.id.q1_5_cb);
        points = checkCB(points, taskCost, cb5, false);

        LinearLayout currentLinearLayout = (LinearLayout) findViewById(R.id.q1_ll);
        checkPoints(points, currentLinearLayout);

        TextView pointsTV = (TextView) findViewById(R.id.points1_text_view);
        showPoints(pointsTV, points);

        pointsTotal += (float) points;
    }


    /**
     * Checks a CheckBox from first question and sets to it BackgroundColor: green if a choice is correct and red if it is incorrect
     * @param currentPoints
     * @param taskCoast
     * @param cb
     * @param rightValue
     * @return
     */
    private float checkCB(float currentPoints, float taskCoast, CheckBox cb, boolean rightValue){
        boolean isChecked = cb.isChecked();
        cb.setClickable(false);
        if (isChecked == rightValue){
            currentPoints += (float) taskCoast;
            Log.v("tag", "currentPoints = "+currentPoints);
            cb.setBackgroundColor(Color.parseColor("#ff99cc00")); //holo_green_light
        }
        else {
            cb.setBackgroundColor(Color.parseColor("#D32F2F")); //red #FF0000 #F44336 #D32F2F
        }
        return currentPoints;
    }

    /**
     * Checks second question.
     */
    private void checkSecondQuestion(){
        float points = 0;

        EditText missingET = (EditText) findViewById(R.id.missing_word_edit_text);
        String textStr = missingET.getText().toString();
        missingET.setClickable(false);
        missingET.setCursorVisible(false);
        missingET.setFocusable(false);
        missingET.setFocusableInTouchMode(false);

        if (textStr.compareTo("EditText") == 0)
            points += (float) 1;

        LinearLayout currentLinearLayout = (LinearLayout) findViewById(R.id.q2_ll);
        checkPoints(points, currentLinearLayout);

        TextView pointsTV = (TextView) findViewById(R.id.points2_text_view);
        showPoints(pointsTV, points);

        pointsTotal += (float) points;
    }

    /**
     * Checks third question.
     */
    private void checkThirdQuestion(){
        float points = 0;

        RadioButton noRB = (RadioButton) findViewById(R.id.q3_no_radio_button);
        noRB.setClickable(false);

        RadioButton yesRB = (RadioButton) findViewById(R.id.q3_yes_radio_button);
        yesRB.setClickable(false);
        if (yesRB.isChecked() == true){
            points += (float) 1;
        }

        LinearLayout currentLinearLayout = (LinearLayout) findViewById(R.id.q3_ll);
        checkPoints(points, currentLinearLayout);

        TextView pointsTV = (TextView) findViewById(R.id.points3_text_view);
        showPoints(pointsTV, points);

        pointsTotal += (float) points;
    }

    private void checkForthQuestion(){
        float points = 0;

        RadioButton q41RB = (RadioButton) findViewById(R.id.q4_1_radio_button);
        q41RB.setClickable(false);

        RadioButton q42RB = (RadioButton) findViewById(R.id.q4_2_radio_button);
        q42RB.setClickable(false);

        RadioButton q43RB = (RadioButton) findViewById(R.id.q4_3_radio_button);
        q43RB.setClickable(false);

        RadioButton q44RB = (RadioButton) findViewById(R.id.q4_4_radio_button);
        q44RB.setClickable(false);


        if (q44RB.isChecked() == true){
            points += (float) 1;
        }

        LinearLayout currentLinearLayout = (LinearLayout) findViewById(R.id.q4_ll);
        checkPoints(points, currentLinearLayout);

        TextView pointsTV = (TextView) findViewById(R.id.points4_text_view);
        showPoints(pointsTV, points);

        pointsTotal += (float) points;
    }
}
