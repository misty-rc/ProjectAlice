package org.misty.rc.projectalice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

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

    static final String T_BUDGET = "T_BUDGET";
    static final String MST_CATEGORY = "MST_CATEGORY";

    static final String COL_ID = "_id";
    static final String COL_CATEGORY = "category";
    static final String COL_DATE = "date";
    static final String COL_MONEY = "money";
    static final String COL_DELETE = "del_flg";

    static final String COL_NAME = "category_name";

    protected static final String DDL_BUDGET = new String(
            "CREATE TABLE " + T_BUDGET + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_CATEGORY + " INTEGER NOT NULL, "
            + COL_DATE + " INTEGER NOT NULL, "
            + COL_MONEY + " INTEGER NOT NULL, "
            + COL_DELETE + " INTEGER);"
    );

    protected static final String DDL_MST_CATEGORY = new String (
            "CREATE TABLE " + MST_CATEGORY + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " STRING NOT NULL, "
            + COL_DELETE + " INTEGER);"
    );

    protected Context _context;
    protected BudgetDBHelper _helper;
    protected SQLiteDatabase _db;

    public BudgetManager(Context context) {
        this._context = context;
        _helper = new BudgetDBHelper(this._context);
    }

    public void open() {
        _db = _helper.getWritableDatabase();
    }

    public void close() {
        _helper.close();
    }

    public void saveMoney(int money, int category) {
        long now = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put(COL_CATEGORY, category);
        values.put(COL_DATE, now);
        values.put(COL_MONEY, money);
        values.put(COL_DELETE, 0);
        _db.insert(T_BUDGET, null, values);
    }

    public Cursor loadMoney() {
        return _db.query(T_BUDGET,null,null,null,null,null,null);
    }

    private static class BudgetDBHelper extends SQLiteOpenHelper {

        public BudgetDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            //外部参照キー
            db.setForeignKeyConstraintsEnabled(true);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("ALICE", DDL_MST_CATEGORY);
            Log.d("ALICE", DDL_BUDGET);

            db.execSQL(DDL_MST_CATEGORY);
            db.execSQL(DDL_BUDGET);

            // test
            String MST_1 = "insert into " + MST_CATEGORY + "(" + COL_NAME + "," + COL_DELETE + ")" + " values ('TEST CATE', 0)";
            String MST_2 = "insert into " + MST_CATEGORY + "(" + COL_NAME + "," + COL_DELETE + ")" + " values ('ABCDEFG', 1)";
            db.execSQL(MST_1);
            db.execSQL(MST_2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
