package org.misty.rc.projectalice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class ExtendedEditText extends EditText {

	public ExtendedEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	
	public void setResult(String result) {
		setText(result);
		Log.d("ALICE", "start: " + this.getSelectionStart());
		Log.d("ALICE", "end: " + getSelectionEnd());
		Log.d("ALICE", "length: " + result.length());
		setSelection(result.length());
	}
}
