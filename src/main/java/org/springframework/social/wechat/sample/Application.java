package org.springframework.social.wechat.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.wechat.autoconfigurer.WechatAutoConfiguration;
import org.springframework.social.wechat.autoconfigurer.WechatMpAutoConfiguration;

@SpringBootApplication
@EnableSocial
@Import({ WechatAutoConfiguration.class, WechatMpAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator,
			UsersConnectionRepository usersConnectionRepository, WechatSignInAdapter wechatSignInAdapter) {
		((InMemoryUsersConnectionRepository) usersConnectionRepository)
				.setConnectionSignUp((Connection<?> connection) -> connection.getKey().getProviderUserId());
		return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, wechatSignInAdapter);
	}

}
