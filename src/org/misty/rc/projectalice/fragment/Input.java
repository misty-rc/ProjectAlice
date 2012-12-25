package org.misty.rc.projectalice.fragment;

import org.misty.rc.projectalice.EventListener;
import org.misty.rc.projectalice.R;
import org.misty.rc.projectalice.view.ExtendedEditText;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Input extends ExtendedFragment {

	public static Input newInstance(int num) {
		Input ins = new Input();
		Bundle args = new Bundle();
		args.putInt("num", num);
		ins.setArguments(args);
		return ins;
	}
	
	public void setHandler(EventListener listener) {
		this._listener = listener;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//for test
		View v = inflater.inflate(R.layout.input4, container, false);

		//bind display
//		_listener.bindDisplay((ExtendedEditText)v.findViewById(R.id.display));
		_listener.bindView(v);
		
		//set spinner
		
		
		TypedArray _buttons = getResources().obtainTypedArray(R.array.buttons);
		for (int i = 0; i < _buttons.length(); i++) {
			Button b = (Button)v.findViewById(_buttons.getResourceId(i, 0));
			b.setOnClickListener(_listener);
			b.setOnLongClickListener(_listener);
		}

		return v;
	}
}
