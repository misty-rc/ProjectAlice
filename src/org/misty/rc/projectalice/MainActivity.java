package org.misty.rc.projectalice;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	SectionPagerAdapter _sectionPagerAdapter;
	Logic _logic;
	EventListener _listener;
	ViewPager _viewPager;
	Context _context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//disable IME for this application
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, 
				WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
		
		setContentView(R.layout.activity_main);

		_context = getApplicationContext();
		_logic = new Logic(_context);
		_listener = new EventListener(_context);
		_listener.setHandler(_logic);
		
		_sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), _context);
		_sectionPagerAdapter.setFragmentListener(_listener);
		_sectionPagerAdapter.setFragmentHandler(_logic);
		
		_viewPager = (ViewPager) findViewById(R.id.pager);
		_viewPager.setAdapter(_sectionPagerAdapter);
		_viewPager.setCurrentItem(1);
	}
	
	void setOnClickListener(View view, int id) {
		final View target = view != null ? view.findViewById(id) : findViewById(id);
		target.setOnClickListener(_listener);
	}
	
	public EventListener getListener() {
		return _listener;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
