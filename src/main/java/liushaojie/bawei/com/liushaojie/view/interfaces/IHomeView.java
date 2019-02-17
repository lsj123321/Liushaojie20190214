package liushaojie.bawei.com.liushaojie.view.interfaces;

import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/15 08:50:47
 * @Description:
 */
public interface IHomeView extends IBaseView {
    void onSuccess(NewsBean bean);
    void onErr(String err);
}
