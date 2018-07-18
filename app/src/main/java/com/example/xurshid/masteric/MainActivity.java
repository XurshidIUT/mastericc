package com.example.xurshid.masteric;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Random r = new Random();
    String userAnswer = "";
    int level = 20;
    int strongest = 1;
    int resultFinal;
    int result;
    String line;
    private TextView trueCount;
    private TextView exercise;
    private int num1;
    private int num2;
    private int count = 0;
//    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited);
//        progressBar = findViewById(R.id.progressBar);
//        progressBar.setMax(60);
        initView();
        generateProblem();
        CheckAndUpgrade();
    }

    @SuppressLint("SetTextI18n")
    private void generateProblem() {
        num1 = r.nextInt(level);
        num2 = r.nextInt(level);
        Random randomCombination = new Random();
        int comb;
        comb = randomCombination.nextInt(3);
        switch (comb) {
            case 0:
                result = num1 + num2;
                line = num1 + "+" + num2;
                exercise.setText(line + "=");
                break;
            case 1:
                result = num1 - num2;
                line = num1 + "-" + num2;
                exercise.setText(line + "=");
                break;
            case 2:
                result = num1 * num2;
                line = num1 + "*" + num2;
                exercise.setText(line + "=");
                break;
            case 3:
                if (num2 == 0) {
                    num2 = r.nextInt();
                    result = num1 / num2;
                    line = num1 + "/" + num2;
                    exercise.setText(line + "=");
                } else {
                    result = num1 / num2;
                    line = num1 + "/" + num2;
                    exercise.setText(line + "=");
                }

        }
        if (num1 < num2) {
            generateProblem();
        }
    }

    @SuppressLint("SetTextI18n")
    private void CheckAndUpgrade() {
        if (resultFinal == result) {
            userAnswer = "";

            line = "";
            generateProblem();
            count++;

            trueCount.setText("Correct: " + count);
        }
    }

    private void initView() {
        trueCount = findViewById(R.id.resultCount);
        exercise = findViewById(R.id.problem);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt0) {
            if (!userAnswer.startsWith("0")) {
                if (userAnswer.length() < 5) {
                    userAnswer += "0";
                    resultFinal = Integer.parseInt(userAnswer);
                    exercise.setText(line + "=" + userAnswer);

                }
            }
        }
        if (view.getId() == R.id.btequal) {
            if (!userAnswer.startsWith("0")) {
                if (userAnswer.length() < 5) {
                    resultFinal = Integer.parseInt(userAnswer);
                    CheckAndUpgrade();
                }
            }
        } else if (view.getId() == R.id.btC) {
            userAnswer = "";
            exercise.setText(line + "=" + userAnswer);
        } else {
            if (userAnswer.length() < 5) {
                Button myButton = (Button) view;
                userAnswer += myButton.getText();
                resultFinal = Integer.parseInt(userAnswer);
                exercise.setText(line + "=" + userAnswer);


            }
        }
    }

//    public void onClickProgressBar(View view) {
//        CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                progressBar.setProgress(100-(int) (millisUntilFinished / 1000));
//
//            }
//
//            @Override
//            public void onFinish() {
//                generateProblem();
//            }
//        };
//        timer.start();
//    }
}
