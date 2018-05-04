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

    private SimpleDateFormat mBirthDateFormat, mActualDateFormat;

    private DatePickerDialog mBirthDatePickerDialog, mActualDatePickerDialog;

    private Calendar mCalendar;

    private Boolean isBirthDateClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        mCalendar = Calendar.getInstance();

        mBirthDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        mActualDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        mBirthDateDisplay = findViewById(R.id.birthDate_display);
        mActualDateDisplay = findViewById(R.id.actualDate_display);
        mLabelYear = findViewById(R.id.LabelYear);

        mBirthDatePickerDialog = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        mActualDatePickerDialog = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));

        findViewById(R.id.birthDate_pick).setOnClickListener(v -> {
            isBirthDateClicked = true;
            mBirthDatePickerDialog.show();
        });
        findViewById(R.id.actualDate_pick).setOnClickListener(v -> {
            isBirthDateClicked = false;
            mActualDatePickerDialog.show();
        });
        findViewById(R.id.cleanButton).setOnClickListener(v -> cleanDate());
    }

    private void cleanDate() {
        mBirthDateDisplay.setText("dd/mm/yyyy");
        mActualDateDisplay.setText("dd/mm/yyyy");
        mLabelYear.setText("0");
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        refreshDate();
    }


    private void refreshDate() {
        if (isBirthDateClicked) {
            mBirthDateDisplay.setText(mBirthDateFormat.format(mCalendar.getTime()));
        } else {
            mActualDateDisplay.setText(mBirthDateFormat.format(mCalendar.getTime()));
        }
    }

}
