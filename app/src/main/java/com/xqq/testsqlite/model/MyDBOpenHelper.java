package com.xqq.testsqlite.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xqq on 2016/11/20.
 */
public class MyDBOpenHelper extends SQLiteOpenHelper {

    public MyDBOpenHelper(Context context){
        // 第一个参数：上下文
        // 第二个参数：数据库的名称
        // 第三个参数：null代表的是默认的游标工厂
        // 第四个参数：数据库的版本号，数据库只能升级，不能降级，版本号只能变大不能变小
        super(context, "person.db", null, 2);
    }
    // 当数据库第一次被创建的时候调用的方法，是个在这个方法里面把数据的表结构定义出来
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person (id integer primary key autoincrement, name varchar(20), number varchar(20))");
    }

    //版本变化时  执行该方法。如果旧的数据库表结构定义的不是特别合理,修改数据库的表结构
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table person add account varchar(20)");
    }
}
