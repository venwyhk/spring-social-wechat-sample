package org.springframework.social.wechat.sample;

import org.springframework.social.wechat.api.User;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.connect.WechatAccessGrant;
import org.springframework.social.wechat.connect.WechatServiceProvider;

public class Test {
	
	public static void main(String[] args) {
		// 授权二维码地址 https://open.weixin.qq.com/connect/qrconnect?appid=wxb333064ae33cf222&redirect_uri=https%3A%2F%2Fapi-dev.leyovisa.com%2Fwechat%2Fcallback.do&response_type=code&scope=snsapi_login&state=3d6be0a4035d839573b04816624a415e#wechat_redirect
		// 返回:https://api-dev.leyovisa.com/wechat/callback.do?code=021Qoath2OV0aJ0s5Pqh2gBhth2Qoatk&state=3d6be0a4035d839573b04816624a415e
		
		// 微信公众平台授权地址 
		// https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6a0440043ed0adf3&redirect_uri=https%3A%2F%2Fapi-dev.leyovisa.com%2Fwechat%2Fcallback.do&response_type=code&scope=snsapi_userinfo&state=3d6be0a4035d839573b04816624a415e#wechat_redirect
		// 获取openid
		// https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6a0440043ed0adf3&secret=6034ef8035d47321cb0a5b66d29a5676&code=021dLShu0CHrSc180Ufu0N9Chu0dLSh5&grant_type=authorization_code
		// 返回:{"access_token":"12_JCNbIAguWDsFvRoMj_d9QmczXLgWq3LgJFhzFQ9Oi_qW_x0eltur_rN9j4aIg1CJjfIhZg3kLMYIyTHDAnQDTdr_wg0FyK9qqkGyHlCGTxI","expires_in":7200,"refresh_token":"12_DdPXFStbIM9NHnnkk7_3GB1tkOmICfq9d83tWb9VuKOhDLRvaHgJJZDxqfEEHVh6vH3LbYAVJfeQLLWEnswlbVVtG6_1KJCLLXfevOU5Iq0","openid":"o9dpys_rXEXzHzNPd-qch6EiqcpM","scope":"snsapi_base"}
		// 获取用户信息
		// https://api.weixin.qq.com/sns/userinfo?access_token=12_pCUIxM2_h_LA3WSAWmaRDm-GK35gVwjjxPfLDCqgOIzWBzh8brFyHXEmaEo8ZyAfkMyN4VtF2kgyQc9GBw4kqV7qFg4QVcVLH4VOtwgM0fw&openid=o9dpys_rXEXzHzNPd-qch6EiqcpM&lang=zh_CN
		
		WechatServiceProvider<Wechat> provider = new WechatServiceProvider<Wechat>("wx2821568e5ae69fa8", "b4cf925b5b49a5f0878fc36a16900be5"); // 微信开放平台申请AppID和AppSecret

		// 授权后得到CODE
		WechatAccessGrant accessGrant = (WechatAccessGrant) provider.getOAuthOperations().exchangeForAccess("061WLyGI0brnOg2UrwDI0BDEGI0WLyGy", "https://xxx.com/signin/wechat", null);

		String accessToken = accessGrant.getAccessToken();

		System.out.println("accessToken : " + accessToken); // 12_eWv-l0U6ArpTNhL5LRKx_AvG-pEPLhr2Hm8qL_tJX0Ytb5ybxf_RbXubLOQs6-LWl10WFxfw4uTtJzZBy9ei0g

		Wechat wechat = provider.getApi(accessToken);

		User user = wechat.userOperations().getUserProfile(accessGrant.getOpenid());

		System.out.println(user);
		// UserInfoRes(openid=oEKZ403S97SPR7QlFj_Z2rJRffyE, nickname=SL, sex=1, language=en, province=Auckland, city=, country=New Zealand, headimgurl=http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKOVzgf7L8bkibHYUUNAo32UibiaY3ebTLVwFBHNLBluYBzCGCSOVmImTRvQ1LMVJbs7U5PYUXD2Gryw/132, privilege=[], unionid=ol0tM1rWeU2mJtCE2QmOI1NcWym0)

		
//		System.out.println(new BCryptPasswordEncoder().encode("thirdParty_WX_ol0tM1rWeU2mJtCE2QmOI1NcWym0_68030903"));
		
	}


}
