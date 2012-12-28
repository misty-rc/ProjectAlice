package org.misty.rc.projectalice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import org.misty.rc.projectalice.view.ExtendedEditText;

public class Logic {
	private Context _context;
//	private TextView _view;
	private ExtendedEditText _exview;
	private Calculable _calc;
	private View _view;
    private BudgetManager _budget;
	
	public Logic(Context context) {
		_context = context;
        _budget = new BudgetManager(this._context);
	}
	
	public void setDisplay(ExtendedEditText view) {
		this._exview = view;
	}
	
	public void bindView(View view) {
//		this._view = view;
		this._exview = (ExtendedEditText)view.findViewById(R.id.display);
	}
	
	public void onClear() {
		Log.d("ALICE", "onClear");
		_exview.setText("");
	}
	
	public void onDelete() {
		Log.d("ALICE", "onDelete");
		_exview.dispatchKeyEvent(new KeyEvent(0, KeyEvent.KEYCODE_DEL));
	}
	
	public void income() {
		
	}
	
	public void expenses() {
		
	}
	
	public void onEqual() {
		Log.d("ALICE", "onEqual");
		try {
			String _input = _exview.getText().toString().trim();
			if (_input.equals("")) {
				// empty
			}

			_calc = new ExpressionBuilder(_input).build();
			double result = _calc.calculate();
			int r = (int)Math.round(result);
			
			_exview.setResult(Integer.toString(r));
//			 _exview.setText(Double.toString(result));
		} catch (Exception e) {

		}
	}
	
	public void insert(String text) {
		Log.d("ALICE", "Insert");
		int cursor = _exview.getSelectionStart();
		_exview.getText().insert(cursor, text);
	}
	
	private String getText() {
		return _exview.getText().toString();
	}
}
