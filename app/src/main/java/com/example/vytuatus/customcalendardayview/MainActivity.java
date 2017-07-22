package com.example.vytuatus.customcalendardayview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private ImageView previousDay;
    private ImageView nextDay;
    private TextView currentDay;
    private Calendar cal = Calendar.getInstance();
    private RelativeLayout mLayout;
    private int eventIndex;
    private View.OnClickListener listener;
    private ImageView temporalEventView;
    
    //Bind the views
    @BindView(R.id.time_00_view) View time_00_view;
    @BindView(R.id.time_01_view) View time_01_view;
    @BindView(R.id.time_02_view) View time_02_view;
    @BindView(R.id.time_03_view) View time_03_view;
    @BindView(R.id.time_04_view) View time_04_view;
    @BindView(R.id.time_05_view) View time_05_view;
    @BindView(R.id.time_06_view) View time_06_view;
    @BindView(R.id.time_07_view) View time_07_view;
    @BindView(R.id.time_08_view) View time_08_view;
    @BindView(R.id.time_09_view) View time_09_view;
    @BindView(R.id.time_10_view) View time_10_view;
    @BindView(R.id.time_11_view) View time_11_view;
    @BindView(R.id.time_12_view) View time_12_view;
    @BindView(R.id.time_13_view) View time_13_view;
    @BindView(R.id.time_14_view) View time_14_view;
    @BindView(R.id.time_15_view) View time_15_view;
    @BindView(R.id.time_16_view) View time_16_view;
    @BindView(R.id.time_17_view) View time_17_view;
    @BindView(R.id.time_18_view) View time_18_view;
    @BindView(R.id.time_19_view) View time_19_view;
    @BindView(R.id.time_20_view) View time_20_view;
    @BindView(R.id.time_21_view) View time_21_view;
    @BindView(R.id.time_22_view) View time_22_view;
    @BindView(R.id.time_23_view) View time_23_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (RelativeLayout) findViewById(R.id.left_event_column);
        temporalEventView = new ImageView(MainActivity.this);
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean la = temporalEventView == null;
                Log.d(TAG, "" + la);
                if (temporalEventView.getTag() == "hello") {
                    ((ViewGroup) temporalEventView.getParent()).removeView(temporalEventView);
                }
                RelativeLayout.LayoutParams lParam = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lParam.topMargin = ((Integer.parseInt(v.getTag().toString()) * 60)) *2;
                lParam.leftMargin = 24;
                temporalEventView.setLayoutParams(lParam);
                temporalEventView.setTag("hello");
                temporalEventView.setPadding(24, 12, 24, 12);
                temporalEventView.setMinimumHeight(120);
                temporalEventView.setMaxHeight(120);
                temporalEventView.getLayoutParams().height = 120;
                //mEventView.setGravity(0x11);
                temporalEventView.setBackgroundColor(Color.parseColor("#ffffff"));
                temporalEventView.setImageResource(R.drawable.put_ivent);
                temporalEventView.setBackgroundColor(Color.parseColor("#3F51B5"));
                Log.d("jaba", "" + mLayout.getChildCount());
                temporalEventView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DetailActivityCalendarView.class));
                    }
                });

                mLayout.addView(temporalEventView, (mLayout.getChildCount() - 1)/2);

            }
        };

        currentDay = (TextView) findViewById(R.id.display_current_date);
        currentDay.setText(displayDateInString(cal.getTime()));
        eventIndex = mLayout.getChildCount();
        ButterKnife.bind(this);
        displayDailyEvents();

        attachClickListeners();

        previousDay = (ImageView) findViewById(R.id.previous_day);
        nextDay = (ImageView) findViewById(R.id.next_day);
        previousDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mLayout.removeViewAt(eventIndex - 1);
                cal.add(Calendar.DAY_OF_MONTH, -1);
//                long millis = cal.getTimeInMillis();
//                cal.setTimeInMillis(millis);
                Log.d("jaba", String.valueOf(cal.getTime()));
                currentDay.setText(displayDateInString(cal.getTime()));
                //displayDailyEvents();
            }
        });

        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mLayout.removeViewAt(eventIndex - 1);
                cal.add(Calendar.DAY_OF_MONTH, 1);
                currentDay.setText(displayDateInString(cal.getTime()));

            }
        });
    }

    private void attachClickListeners() {
        time_00_view.setOnClickListener(listener);
        time_01_view.setOnClickListener(listener);
        time_02_view.setOnClickListener(listener);
        time_03_view.setOnClickListener(listener);
        time_04_view.setOnClickListener(listener);
        time_05_view.setOnClickListener(listener);
        time_06_view.setOnClickListener(listener);
        time_07_view.setOnClickListener(listener);
        time_08_view.setOnClickListener(listener);
        time_09_view.setOnClickListener(listener);
        time_10_view.setOnClickListener(listener);
        time_11_view.setOnClickListener(listener);
        time_12_view.setOnClickListener(listener);
        time_13_view.setOnClickListener(listener);
        time_14_view.setOnClickListener(listener);
        time_15_view.setOnClickListener(listener);
        time_16_view.setOnClickListener(listener);
        time_17_view.setOnClickListener(listener);
        time_18_view.setOnClickListener(listener);
        time_19_view.setOnClickListener(listener);
        time_20_view.setOnClickListener(listener);
        time_21_view.setOnClickListener(listener);
        time_22_view.setOnClickListener(listener);
        time_23_view.setOnClickListener(listener);
    }


    //Display the Date as string in the top middle part of DayView layout
    private String displayDateInString(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("d MMMM, yyyy", Locale.ENGLISH);
        Log.d("jaba", formatter.format(time));
        return formatter.format(time);
    }

    private void displayDailyEvents(){
        Date calendarDate = cal.getTime();

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.HOUR_OF_DAY, -1);
        Date startDate = startCalendar.getTime();
        Log.d("jaba1", String.valueOf(startDate));

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.HOUR_OF_DAY, 0);
        Date endDate = endCalendar.getTime();
        Log.d("jaba1", String.valueOf(endDate));

        int eventBlockHeight = getEventTimeFrame(startDate, endDate); //60 in this case
        Log.d(TAG, "Height " + eventBlockHeight);
        displayEventSection(startDate, eventBlockHeight, "gaidys Event");
    }


    private int getEventTimeFrame(Date start, Date end){
        long timeDifference = end.getTime() - start.getTime();
        Calendar mCal = Calendar.getInstance();
        mCal.setTimeInMillis(timeDifference);
        Log.d("jaba1", String.valueOf(timeDifference/1000/60/60));
        int hours = (int) timeDifference/1000/60/60;
        int minutes = (int) timeDifference/1000/60%60;
        return (hours * 60) + ((minutes * 60) / 100);
    }

    private void displayEventSection(Date eventDate, int height, String message){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        String displayValue = timeFormatter.format(eventDate);
        String[]hourMinutes = displayValue.split(":");
        int hours = Integer.parseInt(hourMinutes[0]);
        int minutes = Integer.parseInt(hourMinutes[1]);
        Log.d(TAG, "Hour value " + hours);
        Log.d(TAG, "Minutes value " + minutes);
        int topViewMargin = (hours * 60) + ((minutes * 60) / 100);
        Log.d(TAG, "Margin top " + topViewMargin);
        createEventView(topViewMargin, height, message);
    }
    private void createEventView(int topMargin, int height, String message){
        TextView mEventView = new TextView(MainActivity.this);
        mEventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Loxas", Toast.LENGTH_SHORT).show();
            }
        });
        RelativeLayout.LayoutParams lParam = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lParam.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        lParam.topMargin = topMargin * 2;
        lParam.leftMargin = 24;
        mEventView.setLayoutParams(lParam);
        mEventView.setPadding(24, 0, 24, 0);
        mEventView.setHeight(height * 2);
        mEventView.setGravity(0x11);
        mEventView.setTextColor(Color.parseColor("#ffffff"));
        mEventView.setText(message);
        mEventView.setBackgroundColor(Color.parseColor("#3F51B5"));
        mLayout.addView(mEventView, eventIndex - 1);
    }


}
