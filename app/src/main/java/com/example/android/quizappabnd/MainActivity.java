package com.example.android.quizappabnd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int answer1 = R.id.radio_dennis;
    private final int answer2 = R.id.radio_larry;
    private final String answer4 = "Lars Bak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resultQuiz(View v) {
        ArrayList<String> wrongAnswersList = new ArrayList<String>();

        int numberOfRightQuestions = 0;

        if (answer1()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add(getString(R.string.firstQue));
        }

        if (answer2()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add(getString(R.string.secQue));
        }
        if (answer3()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add(getString(R.string.thirdQue));
        }
        if (answer4()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add(getString(R.string.fourthQue));
        }

        StringBuilder strbuilder = new StringBuilder();
        for (String s : wrongAnswersList) {
            strbuilder.append(s);
            strbuilder.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = " Correct" + numberOfRightQuestions + "/4 Questions Correct.\n\nRe-Check :\n" + strbuilder.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private boolean answer1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.queNum1);

        if (rg.getCheckedRadioButtonId() == answer1) {
            return true;
        }
        return false;
    }

    private boolean answer2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.queNum2);

        if (rg.getCheckedRadioButtonId() == answer2) {
            return true;
        }
        return false;
    }

    private boolean answer3() {
        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox_ecma);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox_eich);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkBox_lars);

        if (c1.isChecked() && c2.isChecked() && !c3.isChecked()) {
            return true;
        }

        return false;
    }

    private boolean answer4() {
        EditText et = (EditText) findViewById(R.id.dart_edittext);

        return et.getText().toString().equalsIgnoreCase(answer4);
    }
}
