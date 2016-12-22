package com.river.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.newheight.geoquiz.R;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    //问题数组索引变量
    private int mCurrentIndex = 0;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_wuhan, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //根据ID引用组件
        mTrueButton = (Button) findViewById(R.id.ture_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        //设置监听
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) %  mQuestionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void updateQuestion(){
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getQuestion());
    }

    private void checkAnswer(boolean userPressed){
        int messageResId = 0;
        if(userPressed == mQuestionBank[mCurrentIndex].isTrueQuestion()){
            messageResId = R.string.correct_toast;
            Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
        }else{}
    }

    public static void main(String[] args){
        System.out.println(R.string.correct_toast);
    }

}
