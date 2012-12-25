package org.misty.rc.projectalice.fragment;

import org.misty.rc.projectalice.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Currency extends Fragment {

	public static Currency newInstance(int num) {
		Currency ins = new Currency();
		Bundle args = new Bundle();
		args.putInt("num", num);
		ins.setArguments(args);
		
		return ins;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.currency, container, false);
		
		return v;
	}

}
