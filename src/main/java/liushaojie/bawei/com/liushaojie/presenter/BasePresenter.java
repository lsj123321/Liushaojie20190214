package liushaojie.bawei.com.liushaojie.presenter;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/15 08:51:56
 * @Description:
 */
public class BasePresenter<V> {
    private V mView;

    public void setmView(V v) {
        this.mView = v;
    }
    public void dettachView(){
        this.mView=null;
    }
    public V getView(){
        return mView;
    }
}
