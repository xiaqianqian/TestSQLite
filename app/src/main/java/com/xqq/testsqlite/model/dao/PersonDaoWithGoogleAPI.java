package com.xqq.testsqlite.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xqq.testsqlite.model.MyDBOpenHelper;
import com.xqq.testsqlite.model.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xqq on 2016/11/20.
 */
public class PersonDaoWithGoogleAPI {
    private MyDBOpenHelper helper;

    //在构造方法里完成对helper的初始化
    public PersonDaoWithGoogleAPI(Context context) {
        helper = new MyDBOpenHelper(context);
    }
    /**
     * 增加一个
     * @param name
     * @param number
     */
    public long add(String name, String number){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("number", number);
        long id = db.insert("person", null, values);
        db.close();
        return id;
    }

    /**
     * 删除一条记录
     * @param name
     * @return 返回0代表没有删除任何一条数据，返回的整数代表删除了几条数据
     */
    public int delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        int rowCount = db.delete("person", "name=?", new String[]{name});
        db.close();
        return rowCount;
    }

    /**
     * 查询一条记录
     * @param name
     */
    public boolean find(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("person",
                new String[]{"id", "name", "number"},
                "name=?", new String []{name}, null, null, null);
        boolean result = cursor.moveToNext();
        cursor.close();
        db.close();
        return result;
    }

    /**
     * 修改一条记录
     * @param name
     * @param newnumber
     */
    public int update(String name, String newnumber){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", newnumber);
        int updateCount = db.update("person", values, "name=?", new String[]{name});
        db.close();
        return updateCount;
    }

    public List<Person> findAll(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("person",
                new String[]{"id", "name", "number"}, null, null, null, null, null);
        List<Person> persons = new ArrayList<Person>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String number = cursor.getString(cursor.getColumnIndex("number"));

            Person person = new Person(id, name, number);
            persons.add(person);
        }
        cursor.close();
        db.close();
        return persons;
    }
}
