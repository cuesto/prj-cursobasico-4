package widget.infosocial.com.agecalculator;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AgeCalculatorActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private TextView mDateDisplay, mDateTimeDisplay;

    private SimpleDateFormat mDateFormat, mDateTimeFormat;

    private DatePickerDialog mDatePickerDialog;

    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        mCalendar = Calendar.getInstance();

        mDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        mDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        mDateDisplay = findViewById(R.id.birthDate_display);
        mDateTimeDisplay = findViewById(R.id.date_time_display);

        mDatePickerDialog = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));

        findViewById(R.id.birthDate_pick).setOnClickListener(v -> mDatePickerDialog.show());

        //refreshDateTime();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        refreshDateTime();
    }



    private void refreshDateTime() {
        mDateDisplay.setText(mDateFormat.format(mCalendar.getTime()));

        mDateTimeDisplay.setText(mDateTimeFormat.format(mCalendar.getTime()));
    }

}
