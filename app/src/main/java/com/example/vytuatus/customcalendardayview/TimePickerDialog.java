package com.example.vytuatus.customcalendardayview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by vytuatus on 7/17/17.
 */

public class TimePickerDialog extends DialogFragment implements
        android.app.TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        android.app.TimePickerDialog tpd = new android.app.TimePickerDialog(getActivity(), this,
                hour, minute, DateFormat.is24HourFormat(getActivity()));
        tpd.ho

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(getActivity(), hourOfDay + " " + minute, Toast.LENGTH_SHORT).show();
    }
}
