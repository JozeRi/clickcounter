package com.fundamentals.academytlv.refael.clickcounter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

  private static final String EXTRA_DATA_COUNTER = "EDC";

  private TextView mCounterTextView;

  public static void start(Context context, int counter) {
    Intent openSecondActivity = new Intent(context, SecondActivity.class);
    openSecondActivity.putExtra(EXTRA_DATA_COUNTER, counter);
    context.startActivity(openSecondActivity);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    int counterFromIntent = getIntent().getIntExtra(EXTRA_DATA_COUNTER, -1);

    if (counterFromIntent != -1) {
      Toast.makeText(this, "Got the counter successfully!", Toast.LENGTH_SHORT).show();
    }

    mCounterTextView = findViewById(R.id.as_tv_counter);
    mCounterTextView.setText(String.valueOf(counterFromIntent));
  }
}
