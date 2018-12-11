package org.springframework.social.wechat.sample;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.wechat.api.User;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.stereotype.Component;

@Component
public class WechatConnectionSignUp implements ConnectionSignUp {

	@Override
	public String execute(Connection<?> connection) {
		if (connection.getApi() instanceof Wechat) {
			String openId = connection.getKey().getProviderUserId();
			System.out.println(openId); // 微信用户openId
			User user = ((Wechat) connection.getApi()).userOperations().getUserProfile(openId);
			System.out.println(user); // 微信的用户详细信息
			return user.toString();
		}
		return null;
	}

}
