package edu.fsu.cs.mobile.example.dialog4;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerDialogExample extends Activity {
    
	private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;
    
    // mDateSetListener is used in onCreateDialog()
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mDateDisplay = (TextView) findViewById(R.id.textView1);
        mPickDate = (Button) findViewById(R.id.button1);
        mPickDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				showDialog(0);
				
			}
		});
        
        // get the current date
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        // this call initializes the date when the Activity is first created
        updateDisplay();

    }
    
    // updates the date in the TextView
    private void updateDisplay() {
        mDateDisplay.setText((mMonth + 1) + "/" + mDay + "/" + mYear);
    }
    
    @Override
    public Dialog onCreateDialog(int id) {
    
    	return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
    }
}