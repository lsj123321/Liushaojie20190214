package liushaojie.bawei.com.liushaojie.presenter;

import java.io.IOException;

import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;
import liushaojie.bawei.com.liushaojie.model.net.HttpUtils;
import liushaojie.bawei.com.liushaojie.view.interfaces.IHomeView;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/15 08:52:20
 * @Description:
 */
public class HomePresenter extends BasePresenter<IHomeView> implements HttpUtils.CallBackData<NewsBean> {

    private final HttpUtils httpUtils;

    public HomePresenter(){
        httpUtils = HttpUtils.getInstance();
        httpUtils.setCallBack(this);
    }
    public void login(String userName,String passWord){
        httpUtils.postData("",userName,passWord);
    }
    @Override
    public void onResponse(NewsBean newsBean) {
        getView().onSuccess(newsBean);
    }

    @Override
    public void onFailure(IOException e) {

    }
}
