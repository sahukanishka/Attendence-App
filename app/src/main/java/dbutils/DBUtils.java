package dbutils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import model.User;


public class DBUtils {

    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private static String DB_NAME = "atndce";
    private int DB_VERSION = 2;


    public DBUtils(Context context) {

        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);

    }


    public SQLiteDatabase open() {
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return sqLiteDatabase;
    }

    public void close() {
        sqLiteDatabase.close();
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE IF NOT EXISTS " + DataContract.Student.TABLE_NAME + "(" + DataContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DataContract.Student.NAME +
                    " TEXT," + DataContract.Student.TNUMBER + " TEXT," + DataContract.Student.PHONE_NUMBER + " TEXT,"
                    + DataContract.Student.EMAIL_ID
                    + " TEXT);");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + DataContract.Lecture.TABLE_NAME + "(" + DataContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DataContract.Lecture.COURSE_NAME +
                    " TEXT," + DataContract.Lecture.COURSE_DETAILS + " TEXT," + DataContract.Lecture.CLASS_CODE
                    + " text," + DataContract.Lecture.START_DATE_TIME + " text," + DataContract.Lecture.END_DATE_TIME + " text,"
                    + DataContract.Lecture.SELECTED_STUDENTS + " text);");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + DataContract.Attendance.TABLE_NAME + "(" + DataContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DataContract.Attendance.LECTURE_ID +
                    " INTEGER," + DataContract.Attendance.MARK_ATTENDANCE + " INTEGER," + DataContract.Attendance.STUDENT_ID
                    + " INTEGER);");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DataContract.Student.TABLE_NAME + ";");
            db.execSQL("DROP TABLE IF EXISTS " + DataContract.Lecture.TABLE_NAME + ";");
            db.execSQL("DROP TABLE IF EXISTS " + DataContract.Attendance.TABLE_NAME + ";");

            onCreate(db);

        }
    }

        }
