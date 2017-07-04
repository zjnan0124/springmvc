package com.cn.hnust.controller;
import java.io.IOException;
import java.util.Date;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.utis.CheckSumBuilder;

public class Test {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String name = "123456";
		String cid = "7783c94543324a53a6817d4a994bdb7a";
		String url="https://vcloud.163.com/app/vodvideolist";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        Long time = (new Date()).getTime();
        Long time2 = time-(7*24*60*60*1000);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params = new StringEntity("{\"cid\":\"7783c94543324a53a6817d4a994bdb7a\", \"beginTime\":"+time2+",\"endTime\":"+time+"}",Consts.UTF_8);
        httpPost.setEntity(params);
        //发送请求
        HttpResponse res;
		try {
			res = httpClient.execute(httpPost);
//			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
//			httpClient.close();
			String entity = EntityUtils.toString(res.getEntity(),"utf-8");
			JSONObject  json = JSONObject.parseObject(entity);
			System.out.println(json);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
       
	}
	
	/**
	 * 
	* createChannel(创建直播频道)
	* @param type:频道类型 ( 0 : rtmp, 1 : hls, 2 : http)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void createChannel(){
		String url="https://vcloud.163.com/app/channel/create";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params = new StringEntity("{\"name\":\"ne\", \"type\":0}",Consts.UTF_8);
        httpPost.setEntity(params);
        //发送请求
        HttpResponse res;
		try {
			res = httpClient.execute(httpPost);
			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
       
	}
	
	/**
	 * 
	* updateChannel(修改频道)
	* @param  type:频道类型 ( 0 : rtmp, 1 : hls, 2 : http)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void updateChannel(){
		String url="https://vcloud.163.com/app/channel/update";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params = new StringEntity("{\"name\":\"zzzz11111\",\"cid\":\"9f71e1116c554939bb5617e9cf131e7f\", \"type\":0}",Consts.UTF_8);
        httpPost.setEntity(params);
        //发送请求
        HttpResponse res;
		try {
			res = httpClient.execute(httpPost);
			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
       
	}
	
	/**
	 * 
	* deleteChannel(删除频道)
	* @param  type:频道类型 ( 0 : rtmp, 1 : hls, 2 : http)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void deleteChannel(){
		String url="https://vcloud.163.com/app/channel/delete";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params;
		try {
			params = new StringEntity("{\"cid\":\"a90c9857e8084b3abf7af56714c88118\"}");
			 httpPost.setEntity(params);
		        //发送请求
		        HttpResponse res = httpClient.execute(httpPost);
		        System.out.println(EntityUtils.toString(res.getEntity(), "utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	/**
	 * 
	* createChannel(获取频道列表)
	* @param records(单页记录数，默认值为10)
	* pnum(要取第几页，默认值为1)
	* ofield(排序的域，支持的排序域为：ctime(默认))
	* sort(升序还是降序，1升序，0降序，默认为desc)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public static void channelList(){
		String url="https://vcloud.163.com/app/channellist";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params = new StringEntity("{\"records\":\"10\", \"pnum\":1}",Consts.UTF_8);
        httpPost.setEntity(params);
        //发送请求
        HttpResponse res;
		try {
			res = httpClient.execute(httpPost);
			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
       
	}
	
	/**
	 * 
	* channelstats(获取频道状态)
	* @param cid(频道ID，32位字符串)
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void channelstats(){
		String url="https://vcloud.163.com/app/channelstats";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params = new StringEntity("{\"cid\":\"44e14dc35c8042fe85e8ef2815712d5a\"}",Consts.UTF_8);
        httpPost.setEntity(params);
        //发送请求
        HttpResponse res;
		try {
			res = httpClient.execute(httpPost);
			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* setAlwaysRecord(设置频道录制状态)
	* @param cid(频道ID，32位字符串)必填
	* needRecord(1-开启录制； 0-关闭录制)必填
	* format(1-flv； 0-mp4)必填
	* duration(录制切片时长(分钟)，5~120分钟)必填
	* filename(录制后文件名（只支持中文、字母和数字），格式为filename_YYYYMMDD-HHmmssYYYYMMDD-HHmmss, 文件名录制起始时间（年月日时分秒) -录制结束时间（年月日时分秒))
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void setAlwaysRecord(int needRecord){
		String url="https://vcloud.163.com/app/channel/setAlwaysRecord";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params;
		try {
			params = new StringEntity("{\"cid\":\"44e14dc35c8042fe85e8ef2815712d5a\",\"needRecord\":"+needRecord+",\"format\":1,\"duration\":50,\"filename\":\"za\"}",Consts.UTF_8);
			httpPost.setEntity(params);
	        //发送请求
	        HttpResponse res;
	        res = httpClient.execute(httpPost);
			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	/**
	 * 
	* videoList(获取录制视频文件列表)
	* @param name
	* @return String DOM对象
	* @Exception 异常对象
	 */
	public void videoList(int needRecord){
		String name = "123456";
		String cid = "7783c94543324a53a6817d4a994bdb7a";
		String url="https://vcloud.163.com/app/vodvideolist";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00c91f1f3a4bfa180a6ce064d84ba115";
        String appSecret = "97e15ecd1a1d";
        String nonce =  "123456";
        Long time = (new Date()).getTime();
        Long time2 = time-(7*24*60*60*1000);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        //设置请求头
        hread(appKey, nonce, curTime, checkSum, httpPost);
        // 设置请求的参数
        StringEntity params = new StringEntity("{\"cid\":\"7783c94543324a53a6817d4a994bdb7a\", \"beginTime\":"+time2+",\"endTime\":"+time+"}",Consts.UTF_8);
        httpPost.setEntity(params);
        //发送请求
        HttpResponse res;
		try {
			res = httpClient.execute(httpPost);
//			System.out.println(EntityUtils.toString(res.getEntity(),"utf-8"));
//			httpClient.close();
			String entity = EntityUtils.toString(res.getEntity(),"utf-8");
			JSONObject  json = JSONObject.parseObject(entity);
			System.out.println(json);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	
	
	public static void hread(String appKey,String nonce,String curTime,String checkSum,HttpPost httpPost){
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
	}
}
