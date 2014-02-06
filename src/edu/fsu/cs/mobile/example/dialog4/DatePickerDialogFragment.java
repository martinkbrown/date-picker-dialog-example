package edu.fsu.cs.mobile.example.dialog4;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerDialogFragment extends DialogFragment {
	
	private int mYear, mMonth, mDay;
	
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
	
	public static DatePickerDialogFragment newInstance() {
		DatePickerDialogFragment datepickerFragment = new DatePickerDialogFragment();
		return datepickerFragment;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// get the current date
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
		
		return new DatePickerDialog(getActivity(), mDateSetListener, mYear, mMonth, mDay);
	}
    
    // updates the date in the TextView
    private void updateDisplay() {
        ((DatePickerDialogExample) getActivity()).updateDisplay((mMonth + 1), mDay, mYear);
    }
}
