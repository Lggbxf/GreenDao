package cn.whale.greendao.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.whale.greendao.greendao.DaoSession;
import com.whale.greendao.greendao.UserDao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;
    private MyApplication myApp;
    private DaoSession daoSession;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn = (Button) findViewById(R.id.btn);
        myApp = (MyApplication) getApplication();
        daoSession = myApp.getDaoSession();
        userDao = daoSession.getUserDao();

    }


    @OnClick({R.id.btn, R.id.btn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                User user = new User();
                user.setId(1);
                user.setName("小明");
                user.setAge(16);

                userDao.insert(user);
                break;
            case R.id.btn1:
                User user1 = userDao.loadByRowId(1);
                Log.i("MainActivity",user1.getId()+" "+user1.getName()+" "+user1.getAge());
                break;
        }
    }
}
