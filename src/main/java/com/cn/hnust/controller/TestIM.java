package com.cn.hnust.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.cn.hnust.utis.CheckSumBuilderIM;

public class TestIM {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/user/create.action";//f55c261b941e44d285b1ea382510868b
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilderIM.getCheckSum(appSecret, nonce ,curTime);//参考 
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        //设置请求参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", "1"));
        nvps.add(new BasicNameValuePair("name", "qqqq"));
        try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			  //发送请求
	        HttpResponse response  = httpClient.execute(httpPost);
	        // 打印执行结果
	        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* create(创建网易云通信)
	* @param accid(网易云通信ID，最大长度32字符，必须保证一个APP内唯一（只允许字母、数字、半角下划线_、@、半角点以及半角-组成，不区分大小写)必填,
	* name(网易云通信ID昵称，最大长度64字符，用来PUSH推送时显示的昵称),
	* props(json属性，第三方可选填，最大长度1024字符),
	* icon(网易云通信ID头像URL，第三方可选填，最大长度1024),
	* token(网易云通信ID可以指定登录token值，最大长度128字符，并更新，如果未指定，会自动生成token，并在创建成功后返回)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void create(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/user/create.action";//f55c261b941e44d285b1ea382510868b
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilderIM.getCheckSum(appSecret, nonce ,curTime);//参考 
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        //设置请求参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", "047234a8-ae3e-4195-bf7c-8692935653b6"));
        nvps.add(new BasicNameValuePair("name", "qqqq"));
        try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			  //发送请求
	        HttpResponse response  = httpClient.execute(httpPost);
	        // 打印执行结果
	        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* getUinfos(获取用户名片)
	* @param name
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void getUinfos(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/user/getUinfos.action";
		HttpPost httpPost = new HttpPost(url);
		String appKey = "95528cb584cb48738d048aa7db21d991";
        String appSecret = "08d99264d973429ca0ef5f7971c75701";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilderIM.getCheckSum(appSecret, nonce ,curTime);//参考 
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        //设置请求参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accids", "['helloworld123']"));
        try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			 //发送请求
	        HttpResponse response  = httpClient.execute(httpPost);
	        // 打印执行结果
	        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* sendMsg(发送普通消息)
	* @param from(发送者accid，用户帐号，最大32字符，必须保证一个APP内唯一),
	* ope(0：点对点个人消息，1：群消息（高级群），其他返回414),
	* to(ope==0是表示accid即用户id，ope==1表示tid即群id),
	* type(0 表示文本消息,1 表示图片,2 表示语音,3 表示视频,4 表示地理位置信息,6 表示文件,100 自定义消息类型),
	* body(请参考下方消息示例说明中对应消息的body字段，最大长度5000字符，为一个JSON串)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void sendMsg(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/msg/sendMsg.action";
		HttpPost httpPost = new HttpPost(url);
		String appKey = "95528cb584cb48738d048aa7db21d991";
        String appSecret = "08d99264d973429ca0ef5f7971c75701";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilderIM.getCheckSum(appSecret, nonce ,curTime);//参考 
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        //设置请求参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("from", "helloworld123"));
        nvps.add(new BasicNameValuePair("ope", "0"));
        nvps.add(new BasicNameValuePair("to", "helloworld"));
        nvps.add(new BasicNameValuePair("type", "0"));
        nvps.add(new BasicNameValuePair("body", "{'msg':'测试内容'}"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			 //发送请求
		    HttpResponse response  = httpClient.execute(httpPost);
		    // 打印执行结果
		    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* querySessionMsg(聊天历史记录【云端记录】)
	* @param from(发送者accid，用户帐号，最大32字符，必须保证一个APP内唯一),
	* ope(0：点对点个人消息，1：群消息（高级群），其他返回414),
	* to(ope==0是表示accid即用户id，ope==1表示tid即群id),
	* begintime(开始时间，ms),
	* endtime(截止时间，ms),
	* limit(本次查询的消息条数上限(最多100条),小于等于0，或者大于100，会提示参数错误),
	* reverse(1按时间正序排列，2按时间降序排列。其它返回参数414错误.默认是按降序排列)[非必填字段]
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void querySessionMsg(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/msg/sendMsg.action";
		HttpPost httpPost = new HttpPost(url);
		String appKey = "95528cb584cb48738d048aa7db21d991";
        String appSecret = "08d99264d973429ca0ef5f7971c75701";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilderIM.getCheckSum(appSecret, nonce ,curTime);//参考 
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        //设置请求参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("from", "helloworld123"));
        nvps.add(new BasicNameValuePair("ope", "0"));
        nvps.add(new BasicNameValuePair("to", "helloworld"));
        nvps.add(new BasicNameValuePair("type", "0"));
        nvps.add(new BasicNameValuePair("body", "{'msg':'测试内容'}"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			 //发送请求
		    HttpResponse response  = httpClient.execute(httpPost);
		    // 打印执行结果
		    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* createChatroom(创建聊天室)
	* @param name
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void createChatroom(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/chatroom/create.action";
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilderIM.getCheckSum(appSecret, nonce ,curTime);//参考 
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        //设置请求参数
        Long time1 = new Date().getTime();
        Long time2 = time1-1000000;
        Long time3 = time1+1000000;
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("creator", "hell1"));
        nvps.add(new BasicNameValuePair("name", "测试聊天室"));
        nvps.add(new BasicNameValuePair("announcement","直播频道公告"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			 //发送请求
		    HttpResponse response  = httpClient.execute(httpPost);
		    // 打印执行结果
		    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
	}
	
	public static void hread(String appKey,String nonce,String curTime,String checkSum,HttpPost httpPost){
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	}
}
