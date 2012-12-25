package org.misty.rc.projectalice.view;

import org.misty.rc.projectalice.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TestView extends TextView {

	public TestView(Context context, AttributeSet attrs) {
		super(context);
		TypedArray tarray = context.obtainStyledAttributes(attrs, R.styleable.TestView);

		try {
			setText(tarray.getText(R.styleable.TestView_text));
			setTextColor(tarray.getColor(R.styleable.TestView_color, 0));
			setTextSize(tarray.getDimension(R.styleable.TestView_size, 12));
			setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/mikachan.ttf"));
		} finally {
			tarray.recycle();
		}
	}
	
	
}
