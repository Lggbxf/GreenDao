package cn.whale.greendao.greendao;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.whale.greendao.greendao.DaoMaster;
import com.whale.greendao.greendao.DaoSession;
import com.whale.greendao.greendao.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

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

//删除记录
    public void delete(User user){
        userDao.delete(user);
    }

    public void deleteByUserId(long userid){
        userDao.deleteByKey(1L);
    }
//更新记录
    public void update(User user){
        userDao.update(user);
    }

//查询记录
    public List<User> query(){
        return userDao.loadAll();// 查询所有记录
    }

    public User query2(){
        return userDao.loadByRowId(1);//根据ID查询
    }

    public List<User> query2(){
        return userDao.queryRaw("where AGE>?","10");//查询年龄大于10的用户
    }

    //查询年龄大于10的用户
    public List<User> query4(){
        QueryBuilder<User> builder = userDao.queryBuilder();
        return  builder.where(UserDao.Properties.Age.gt(10)).build().list();
    }

}
