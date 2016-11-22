package com.xqq.testsqlite.model.dao;

/**
 * Created by xqq on 2016/11/20.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xqq.testsqlite.model.MyDBOpenHelper;
import com.xqq.testsqlite.model.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 对数据库的增删改查
 */
public class PersonDao {
    private MyDBOpenHelper helper;

    //在构造方法里完成对helper的初始化
    public PersonDao(Context context) {
        helper = new MyDBOpenHelper(context);
    }

    /**
     * 增加一个
     * @param name
     * @param number
     */
    public void add(String name, String number){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into person (name,number) values (?,?)", new Object []{name,number});
        db.close();
    }

    /**
     * 删除一条记录
     * @param name
     */
    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from person where name=?", new Object []{name});
        db.close();
    }

    /**
     * 查询一条记录
     * @param name
     */
    public boolean find(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from person where name=?", new String []{name});
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
    public void update(String name, String newnumber){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update person set number=? where name=?", new Object []{name,newnumber});
        db.close();
    }

    public List<Person> findAll(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from person", null);
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
