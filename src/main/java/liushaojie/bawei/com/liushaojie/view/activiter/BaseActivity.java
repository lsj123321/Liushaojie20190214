package liushaojie.bawei.com.liushaojie.view.activiter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import liushaojie.bawei.com.liushaojie.R;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/15 08:51:06
 * @Description:
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}