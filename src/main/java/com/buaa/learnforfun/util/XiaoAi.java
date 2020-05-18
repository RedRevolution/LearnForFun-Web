package com.buaa.learnforfun.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XiaoAi {
    public static String getResponse(String question) {
        BufferedReader in = null;
        try {
            String ini = "{'sessionId':'09e2aca4d0a541f88eecc77c03a8b393','robotId':'webbot','userId':'462d49d3742745bb98f7538c42f9f874','body':{'content':'" + question + "'},'type':'txt'}&ts=1529917589648";
            String url = "http://i.xiaoi.com/robot/webrobot?&callback=__webrobot_processMsg&data=" + URLEncoder.encode(ini, "UTF-8");
            String cookieString = "cnonce:808116;nonce:273765;" +
                    "sig:0c3021aa5552fe597bb55448b40ad2a90d2dead5;" +
                    "XISESSIONID:hlbnd1oiwar01dfje825gavcn;" +
                    "hibext_instdsigdip2:1";
            URL xiaoAiurl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = xiaoAiurl.openConnection();
            connection.setRequestProperty("Cookie", cookieString);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) sb.append(line);
            String response = sb.toString();
            System.out.println(response);
            Pattern p = Pattern.compile("\"fontColor\":0,\"content\":\"(.*?)\"");
            Matcher m = p.matcher(response);
            m.find();m.find();
            String ans = m.group(1);
            return ans.substring(0,ans.length()-4);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        } finally {   // 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
