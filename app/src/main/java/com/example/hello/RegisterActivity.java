package com.example.hello;

import android.annotation.SuppressLint;
//import android.view.Menu;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
//import android.view.MenuItem;
//import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.view.View;
//import com.example.hello.R;
//import android.widget.Button;
import android.widget.Button;
import android.widget.DatePicker;
//import android.widget.EditText;
import android.widget.Toast;

//import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Locale;
//import java.util.Objects;


@SuppressLint("Registered")
public class RegisterActivity extends AppCompatActivity {

    private DatePickerFragment datePickerFragment;
    private static Calendar dateTime = Calendar.getInstance();

    protected static int mYear;
    protected static int mMonth;
    protected static int mDay;

    private static final int allowedDOB = 18;

    Button btn_submit, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);

        Button dobButton = findViewById(R.id.select_dob);
        dobButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getSupportFragmentManager(), "Select Your Birthday");

                  btn_submit = (Button) findViewById(R.id.btn_submit);
                  btn_back = (Button) findViewById(R.id.btn_back);

                    btn_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Welcome - Thanks for Signing Up", Toast.LENGTH_LONG).show();
                        }
                    });

                    btn_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Another Account", Toast.LENGTH_LONG).show();
                           onDestroy();
                        }
                    });
                }
        });
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Using current date as start Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(requireActivity(), this, mYear, mMonth, mDay);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            dateTime.set(mYear, monthOfYear, dayOfMonth);
            long selectDateInMilliSeconds = dateTime.getTimeInMillis();

            Calendar currentDate = Calendar.getInstance();
            long currentDateInMilliSeconds = currentDate.getTimeInMillis();

            if (selectDateInMilliSeconds > currentDateInMilliSeconds) {
                Toast.makeText(getActivity(), "Your birthday date must come before taday's date", Toast.LENGTH_LONG).show();
                return;
            }

            long diffDate = currentDateInMilliSeconds - selectDateInMilliSeconds;
            Calendar yourAge = Calendar.getInstance();
            yourAge.setTimeInMillis(diffDate);

            long returnedYear = yourAge.get(Calendar.YEAR) - 2002;

            if (returnedYear < allowedDOB) {
               Toast.makeText(getActivity(), "You are under 18 years of age.", Toast.LENGTH_LONG).show();
                OnBackPressed();
            }  // move to another activity page
        }

        private void OnBackPressed() {
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}






