package com.fundamentals.academytlv.refael.clickcounter;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private static final String STATE_COUNTER = "SC";

  private int mCounter = 0;

  private TextView mCounterTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mCounterTextView = findViewById(R.id.am_tv_counter);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      mCounter = savedInstanceState.getInt(STATE_COUNTER);
      updateCounterValue(mCounter);
    }
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onSaveInstanceState(Bundle savedInstanceState) {
    savedInstanceState.putInt(STATE_COUNTER, mCounter);
    super.onSaveInstanceState(savedInstanceState);
  }

  public void increaseCount(View view) {
    mCounter++;

    if (mCounter > 10) {
      navigateToSecondActivity();
      return;
    }

    updateCounterValue(mCounter);
  }

  private void updateCounterValue(int value) {
    mCounterTextView.setText(String.valueOf(value));
  }

  private void navigateToSecondActivity() {
    SecondActivity.start(this, mCounter);
  }
}
