package com.example.vytuatus.customcalendardayview;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivityCalendarView extends AppCompatActivity {

    private TextView mStartTime, mEndTime, mDateDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_calendar_view);

        mStartTime = (TextView) findViewById(R.id.textView_start_time);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerDialog();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}
