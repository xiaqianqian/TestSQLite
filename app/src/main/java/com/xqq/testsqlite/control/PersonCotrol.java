package com.xqq.testsqlite.control;

import android.content.Context;

import com.xqq.testsqlite.model.dao.PersonDao;
import com.xqq.testsqlite.model.dao.PersonDaoWithGoogleAPI;

/**
 * Created by xqq on 2016/11/22.
 */
public class PersonCotrol {
    private PersonDao personDao;
    private PersonDaoWithGoogleAPI personDaoWithGoogleAPI;

    public PersonCotrol(Context context) {
        personDao = new PersonDao(context);
        personDaoWithGoogleAPI = new PersonDaoWithGoogleAPI(context);
    }

    public Long add(String name, String number, boolean isGoogle) {
        if(isGoogle){
            return personDaoWithGoogleAPI.add(name, number);
        }else{
            personDao.add(name, number);
            return null;
        }
    }

    public Integer delete(String name, boolean isGoogle){
        if(isGoogle){
            return personDaoWithGoogleAPI.delete(name);
        }else{
            personDao.delete(name);
            return null;
        }
    }

    public Integer update(String name, String newNumber, boolean isGoogle){
        if(isGoogle){
            return personDaoWithGoogleAPI.update(name, newNumber);
        }else{
            personDao.update(name, newNumber);
            return null;
        }
    }


    public Boolean search(String name, boolean isGoogle) {
        if(isGoogle){
            return personDaoWithGoogleAPI.find(name);
        }else{
            personDao.find(name);
            return null;
        }
    }
}
