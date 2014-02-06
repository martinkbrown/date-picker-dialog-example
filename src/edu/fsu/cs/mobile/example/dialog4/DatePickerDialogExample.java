package edu.fsu.cs.mobile.example.dialog4;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatePickerDialogExample extends Activity {
	
	private final String DIALOG_TAG = "DATEPICKER_DIALOG";
    
	private TextView mDateDisplay;
    private Button mPickDate;
    
    private int year;
    private int month;
    private int day;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mDateDisplay = (TextView) findViewById(R.id.textView1);
        mPickDate = (Button) findViewById(R.id.button1);
        mPickDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialogFragment.newInstance().show(getFragmentManager(), DIALOG_TAG);
			}
		});
        
        // get the current date
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        // this call initializes the date when the Activity is first created
        updateDisplay(month, day, year);
    }
    
    // updates the date in the TextView
    public void updateDisplay(int mMonth, int mDay, int mYear) {
        mDateDisplay.setText(mMonth + "/" + mDay + "/" + mYear);
    }
}