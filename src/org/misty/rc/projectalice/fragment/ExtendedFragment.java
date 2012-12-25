package org.misty.rc.projectalice.fragment;

import org.misty.rc.projectalice.EventListener;

import android.support.v4.app.Fragment;

public class ExtendedFragment extends Fragment {
	
	protected EventListener _listener;
	
	public void setListener(EventListener listener) {
		this._listener = listener;
	}
}
