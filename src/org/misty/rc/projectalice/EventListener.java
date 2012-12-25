package org.misty.rc.projectalice;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import org.misty.rc.projectalice.view.ExtendedEditText;

public class EventListener implements OnClickListener, OnKeyListener,
		OnLongClickListener {

	Logic _handler;
	Context _context;
	
	public EventListener(Context context) {
		this._context = context;
	}
	
	public void setHandler(Logic logic) {
		_handler = logic;
	}
	
	public void bindDisplay(ExtendedEditText display) {
		_handler.setDisplay(display);
	}

    // test comment
	public void bindView(View view) {
		_handler.bindView(view);
	}
	
	@Override
	public boolean onLongClick(View view) {
		Log.d("ALICE", "onLongClick Event");
		int id = view.getId();
		if(id == R.id.clear) {
			//clear
			_handler.onClear();
			return true;
		}
		return false;
	}

	@Override
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.clear:
                //1char del
                _handler.onDelete();
                break;
            case R.id.equal:
                //equal
                _handler.onEqual();
                break;
            case R.id.income:
                //income
                _handler.income();
                break;
            case R.id.expenses:
                //expenses
                _handler.expenses();
                break;
            default:
                if(view instanceof Button) {
                    String text = ((Button) view).getText().toString();
                    _handler.insert(text);
                }
        }
    }

/*	@Override
	public void onFocusChange(View view, boolean hasFocus) {
		InputMethodManager _immanager =
				(InputMethodManager) _context.getSystemService(Context.INPUT_METHOD_SERVICE);
		// always hide
		_immanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
*/
}
