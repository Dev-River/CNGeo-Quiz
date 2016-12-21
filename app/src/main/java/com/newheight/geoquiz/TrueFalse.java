package com.newheight.geoquiz;

/**
 * Created by huanghe3 on 2016/12/21.
 */

public class TrueFalse {
    private int mQuestion;//问题字符串资源ID
    private boolean mTrueQuestion;//答案是否正确

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}
