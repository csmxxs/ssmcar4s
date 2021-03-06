package com.ylms.liuliangbao.config;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.ylms.liuliangbao.utlis.HmacSHA256;
import com.ylms.liuliangbao.utlis.HttpUtil;
import com.ylms.liuliangbao.utlis.XXTea;

public class SmsCode {
	// 时间戳毫秒
	public static Long timeStamp = System.currentTimeMillis();
	/** 接口参数加密 */
	public static String getParams(String mobile) {
		String params = "";
		try {
			params = XXTea.encrypt("mobile=" + mobile, "UTF-8",
					XXTea.toHex(Common.APP_SECRET.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}
	/**
	 * 公共的参数和接口参数加密后形成的参数进行加密
	 */
	public static String getSign(String params) {
		return HmacSHA256.generateHmacSha256Signature(Common.APP_ID
				+ SmsCode.timeStamp + Common.version + params,
				Common.SIGNSECRET);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		Map<String, String> params = new HashMap<String, String>();
//		// 获取短信验证码接口
//		String mhttpUrl = "https://nb.189.cn/open/auth/getSmsCode.do";
//		// 开始构建请求参数
//		String param = SmsCode.getParams("18922741573");
//		String sign = SmsCode.getSign(param);
//		params.put("timeStamp", "" + SmsCode.timeStamp);
//		params.put("appId", Common.APP_ID);
//		params.put("version", Common.version);
//		params.put("params", param);
//		params.put("sign", sign);
//		String msg = HttpUtil.doGet(mhttpUrl, params);
//		if (msg != null) {
//			// 转换成map格式
//			Map<String,Object> map=JSON.parseObject(msg, Map.class);
//            if(map.containsKey("result")){
//            	System.out.println("访问成功，返回信息:");
//            	for (Map.Entry<String, Object> s : map.entrySet()) {
//				System.out.println(s.getKey()+":"+s.getValue());
//				}
//            }
//		}
	}

}