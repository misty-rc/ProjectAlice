package org.misty.rc.projectalice;

import org.misty.rc.projectalice.fragment.Currency;
import org.misty.rc.projectalice.fragment.Input;
import org.misty.rc.projectalice.fragment.Summary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Button;

public class SectionPagerAdapter extends FragmentPagerAdapter {
	private static final int PAGES = 3;
	private Context _context;
	private Logic _logic;
	private EventListener _listener;

	public SectionPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		this._context = context;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return Summary.newInstance(position);
		case 1:
			Input input = Input.newInstance(position);
			input.setListener(_listener);

			return input;
		case 2:
			return Currency.newInstance(position);
		}
		return null;
	}

	@Override
	public int getCount() {
		return PAGES;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return "統計";
			// return getString(R.string.title_section1).toUpperCase();
		case 1:
			return "入力";
			// return getString(R.string.title_section2).toUpperCase();
		case 2:
			return "タイムライン";
			// return getString(R.string.title_section3).toUpperCase();
		}
		return null;
	}

	public void setFragmentListener(EventListener _listener) {
		this._listener = _listener;

	}

	public void setFragmentHandler(Logic _logic) {
		this._logic = _logic;
	}
}
