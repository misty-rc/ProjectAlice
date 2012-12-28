package org.misty.rc.projectalice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: arai
 * Date: 12/12/28
 * Time: 15:56
 * To change this template use File | Settings | File Templates.
 */
public class BudgetManager {
    private static final String DB_NAME = "budget_db";
    private static final int DB_VERSION = 1;

    Context _context;
    BudgetDBHelper _helper;

    public BudgetManager(Context context) {
        this._context = context;
        _helper = new BudgetDBHelper(this._context);
    }

    public void open() {
        _helper.getReadableDatabase();
    }

    private static class BudgetDBHelper extends SQLiteOpenHelper {

        public BudgetDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            db.setForeignKeyConstraintsEnabled(true);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
