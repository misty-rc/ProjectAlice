package org.misty.rc.projectalice.view;

import org.misty.rc.projectalice.MainActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NumpadButton extends Button implements OnClickListener {

	OnClickListener _listener;
	
	public NumpadButton(Context context, AttributeSet attrs) {
		super(context, attrs);
//		MainActivity _main = (MainActivity) context;
//		_listener = _main.mListener;
//		setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		_listener.onClick(this);
	}

	@Override
	protected void onTextChanged(CharSequence text, int start, int before, int after) {
		super.onTextChanged(text, start, before, after);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

}
