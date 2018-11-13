package cn.whale.greendao.greendao;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.whale.greendao.greendao.DaoMaster;
import com.whale.greendao.greendao.DaoSession;

/**
 * Created by nuts on 2018/11/13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    public DaoSession daoSession;
    public void initGreenDao(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"aa.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }


    public DaoSession getDaoSession(){
        return daoSession;
    }
}
