package com.hp.szy.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {



 @Test
public  void test1() throws IOException {
     String result;
     HttpGet get=new HttpGet("http://baidu.com");

     HttpClient client = HttpClientBuilder.create().build();
     client.execute(get);

     HttpResponse response=client.execute(get);
     result= EntityUtils.toString(response.getEntity());

     System.out.println(result);

    }





}
