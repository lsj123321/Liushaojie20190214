package liushaojie.bawei.com.liushaojie.model.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/15 08:52:31
 * @Description:
 */
public class HttpUtils {
    private HttpUtils(){}
    private static HttpUtils httpUtils;
    CallBackData callBack;

    public void setCallBack(CallBackData callBack) {
        this.callBack = callBack;
    }
    public static HttpUtils getInstance(){
        if (httpUtils==null){
            return new HttpUtils();
        }else{
            return httpUtils;
        }
    }
    public void getData(String url,String userName,String passWord){

    }
    public void postData(String url,String userName,String passWord){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(null)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("userName", userName)
                .add("passWord", passWord)
                .build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(string, NewsBean.class);
                callBack.onResponse(newsBean);
            }
        });

    }

    public interface CallBackData<D>{
        void onResponse(D d);
        void onFailure(IOException e);
    }

}
