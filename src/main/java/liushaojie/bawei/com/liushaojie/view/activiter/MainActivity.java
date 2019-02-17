package liushaojie.bawei.com.liushaojie.view.activiter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import liushaojie.bawei.com.liushaojie.R;
import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;
import liushaojie.bawei.com.liushaojie.presenter.HomePresenter;
import liushaojie.bawei.com.liushaojie.view.interfaces.IHomeView;

public class MainActivity extends BaseActivity implements IHomeView,View.OnClickListener {

    private HomePresenter homePresenter;
    private String path = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inirView();
        initData();
    }

    private void inirView() {

    }

    private void initData() {
        homePresenter = new HomePresenter();
        homePresenter.setmView(this);
    }



    @Override
    public void onSuccess(NewsBean bean) {

    }

    @Override
    public void onErr(String err) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.dettachView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login:
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
                break;
            case R.id.login_register:
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                break;
        }
    }
}
