package com.buaa.learnforfun.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.context.request.RequestScope;

public class XiaoAi {
    Cookie cookies = new Cookie("cnonce","808116");
    CookieStore cookieStore = new BasicCookieStore();
    BasicCookieStore cookie = new BasicCookieStore().addCookies();

    //1.打开浏览器
    CloseableHttpClient httpClient = HttpClients.createDefault();
    //2.声明get请求
    HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=java");
    //3.发送请求
    CloseableHttpResponse response = httpClient.execute(httpGet);
    //4.判断状态码
        if(response.getStatusLine().getStatusCode()==200){
        HttpEntity entity = response.getEntity();
        //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
        String string = EntityUtils.toString(entity, "utf-8");
        System.out.println(string);
    }
    //5.关闭资源
        response.close();
        httpClient.close();


}
