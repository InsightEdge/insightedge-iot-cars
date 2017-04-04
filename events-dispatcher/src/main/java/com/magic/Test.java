package com.magic;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Test magic endpoint
 *
 * @author Oleksiy_Dyagilev
 */
public class Test {

    static String postUrl = "http://cloud.magicsoftware.de/Magicxpi4.5/MgWebRequester.dll";
    static String payload = "CarEvent(2131650,M050UB92BRT2,459545,15 UB92 130SWB121,8813,1,22610022,17446774,1,14,750,30.0,26.60000038,23.79999924,1.49000001,1.5,9.0,9,-0.493000001,604.0,false)";

    public static void main(String[] args) throws IOException {

      CarEventDispatcher.httpPost(postUrl, payload);


    }


}
