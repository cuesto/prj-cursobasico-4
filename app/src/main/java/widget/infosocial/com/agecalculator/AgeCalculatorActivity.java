package widget.infosocial.com.agecalculator;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AgeCalculatorActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView mBirthDateDisplay, mActualDateDisplay, mLabelYear;

    private SimpleDateFormat mDateFormat;

    private DatePickerDialog mBirthDatePickerDialog, mActualDatePickerDialog;

    private Calendar mCalendar;

    private Boolean mIsBirthDateClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        mCalendar = Calendar.getInstance();

        mDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        mBirthDateDisplay = findViewById(R.id.birthDate_display);
        mActualDateDisplay = findViewById(R.id.actualDate_display);
        mLabelYear = findViewById(R.id.LabelYear);

        mBirthDatePickerDialog = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        mActualDatePickerDialog = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));

        findViewById(R.id.birthDate_pick).setOnClickListener(v -> {
            mIsBirthDateClicked = true;
            mBirthDatePickerDialog.show();
        });
        findViewById(R.id.actualDate_pick).setOnClickListener(v -> {
            mIsBirthDateClicked = false;
            mActualDatePickerDialog.show();
        });
        findViewById(R.id.cleanButton).setOnClickListener(v -> cleanDate());
        findViewById(R.id.calculateDateButton).setOnClickListener(v -> calculateDate());
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        refreshDate();
    }

    private void refreshDate() {
        if (mIsBirthDateClicked) {
            mBirthDateDisplay.setText(mDateFormat.format(mCalendar.getTime()));
        } else {
            mActualDateDisplay.setText(mDateFormat.format(mCalendar.getTime()));
        }
    }

    private void cleanDate() {
        mBirthDateDisplay.setText(R.string.label_date);
        mActualDateDisplay.setText(R.string.label_date);
        mLabelYear.setText("0");
    }

    private void calculateDate() {
        int mBirthYear = mBirthDatePickerDialog.getDatePicker().getYear();
        int mActualYear = mActualDatePickerDialog.getDatePicker().getYear();

        mLabelYear.setText(String.valueOf(Math.abs(mBirthYear - mActualYear)));

    }

}
