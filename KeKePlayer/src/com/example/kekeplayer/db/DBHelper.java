package com.example.kekeplayer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
  public static final String AMOUNT = "amount";
  public static final String COLLECT_IDX = "CREATE UNIQUE INDEX 'collect_idx' ON 'collect' ('content_id' , 'content_type_id' );";
  public static final String COLLECT_SQL = "CREATE  TABLE 'collect' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'total' VARCHAR, 'content_id' VARCHAR, 'content_type_id' VARCHAR, 'intro' VARCHAR, 'pic' VARCHAR ,'liveurl' VARCHAR)";
  public static final String CURRENT_SIZE = "currentSize";
  public static final String CURRENT_STATUS = "currentStatus";
  public static final String HISTORY_IDX = "CREATE UNIQUE INDEX 'history_idx' ON 'history' ('content_id' , 'content_type_id' );";
  public static final String HISTORY_SQL = "CREATE  TABLE 'history' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'total' VARCHAR, 'content_id' VARCHAR, 'content_type_id' VARCHAR, 'series_num' VARCHAR,'position' INTEGER DEFAULT 0, 'pic' VARCHAR,'update_time' TIMESTAMP default (datetime('now', 'localtime')))";
  public static final String ID = "_id";
  public static final String IMAGE_URL = "imageUrl";
  private static final String NAME = "cbox.sqlite";
  public static final String REMIND_IDX = "CREATE UNIQUE INDEX 'remind_idx' ON 'remind' ('title' , 'remind_time' );";
  public static final String REMIND_SQL = "CREATE  TABLE 'remind' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'channel_name' VARCHAR, 'remind_time' datetime default (datetime('now', 'localtime')) ,'is_new' INTEGER DEFAULT 0, 'pic' VARCHAR)";
  public static final String SRC_URL = "srcUrl";
  public static final String SUBSCIBE_IDX = "CREATE UNIQUE INDEX 'subscibe_idx' ON 'subscibe' ('content_id' , 'content_type_id' );";
  public static final String SUBSCIBE_SQL = "CREATE  TABLE 'subscibe' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'part' VARCHAR, 'total' VARCHAR, 'content_id' VARCHAR, 'content_type_id' VARCHAR, 'is_new' INTEGER DEFAULT 0, 'pic' VARCHAR)";
  public static final String TABLE_NAME_COLLECT = "collect";
  public static final String TABLE_NAME_HISTORY = "history";
  public static final String TABLE_NAME_REMIND = "remind";
  public static final String TABLE_NAME_SUBSCIBE = "subscibe";
  public static final String VIDEO_ID = "videoId";
  public static final String VIDEO_SIZE = "videoSize";
  public static final String VIDEO_TITLE = "videoTitle";
  public static final String WHICH_SECTION = "whichSection";
  private Context mContext;

  public DBHelper(Context paramContext)
  {
    super(paramContext, NAME, null, 1);
    this.mContext = paramContext;
  }

  public DBHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.mContext = paramContext;
  }

  public void checkVersionCreate(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = paramSQLiteDatabase.getVersion();
    if (i != paramInt)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.setVersion(paramInt);
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }

  public SQLiteDatabase getDatabase(SQLiteDatabase paramSQLiteDatabase, Context paramContext, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return paramContext.openOrCreateDatabase(NAME, 0, paramCursorFactory);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE  TABLE 'history' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'total' VARCHAR, 'content_id' VARCHAR, 'content_type_id' VARCHAR, 'series_num' VARCHAR,'position' INTEGER DEFAULT 0, 'pic' VARCHAR,'update_time' TIMESTAMP default (datetime('now', 'localtime')))");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX 'history_idx' ON 'history' ('content_id' , 'content_type_id' );");
    paramSQLiteDatabase.execSQL("CREATE  TABLE 'collect' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'total' VARCHAR, 'content_id' VARCHAR, 'content_type_id' VARCHAR, 'intro' VARCHAR, 'pic' VARCHAR ,'liveurl' VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX 'collect_idx' ON 'collect' ('content_id' , 'content_type_id' );");
    paramSQLiteDatabase.execSQL("CREATE  TABLE 'remind' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'channel_name' VARCHAR, 'remind_time' datetime default (datetime('now', 'localtime')) ,'is_new' INTEGER DEFAULT 0, 'pic' VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX 'remind_idx' ON 'remind' ('title' , 'remind_time' );");
    paramSQLiteDatabase.execSQL("CREATE  TABLE 'subscibe' ('_id' INTEGER PRIMARY KEY  AUTOINCREMENT , 'title' VARCHAR, 'part' VARCHAR, 'total' VARCHAR, 'content_id' VARCHAR, 'content_type_id' VARCHAR, 'is_new' INTEGER DEFAULT 0, 'pic' VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX 'subscibe_idx' ON 'subscibe' ('content_id' , 'content_type_id' );");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTSsubscibe");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTScollect");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTShistory");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTSremind");
    onCreate(paramSQLiteDatabase);
  }
}