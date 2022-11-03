package org.springframework.social.wechat.sample;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.api.Wecom;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class WechatSignInAdapter implements SignInAdapter {

	@Override
	public String signIn(String openId, Connection<?> connection, NativeWebRequest request) {
		ConnectionKey key = connection.getKey();
		// 这里的if判断可对微信开放平台和微信公众平台帐号登录做不同的逻辑处理，此例子代码处理逻辑相同
		if ("wechat".equalsIgnoreCase(key.getProviderId()) || "wechatmp".equalsIgnoreCase(key.getProviderId()))
			// 默认语言为英文，如果想切换为中文可改为：getUserProfile(openId,WechatLangEnum.ZH_CN);
			System.out.println(((Wechat) connection.getApi()).userOperations().getUserProfile(openId)); // 打印用户详细信息
		if ("wecom".equalsIgnoreCase(key.getProviderId())) // 企业微信扫码授权
			// WecomUser对象只返回部分信息，如果需要更多信息可以自定义对象替换WecomUser，详见企业微信官方文档
			System.out.println(((Wecom) connection.getApi()).userOperations().getUserProfile(openId)); // 打印用户详细信息
		return "/login.htm"; // 返回跳转的url
	}

}