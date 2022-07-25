package org.hgc.authentication;

import org.hgc.authentication.mapper.UserMapper;
import org.hgc.authentication.model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Resource
	private UserMapper userMapper;

	@Resource
	private PasswordEncoder passwordEncoder;

	/**
	 * 测试 MybatisPlus
	 */
	@Test
	void contextMybatisPlus() {
		List<User> users = userMapper.selectList(null);
		users.forEach(t -> System.out.println(t.getName()));
	}

	/**
	 * 生成加密密码
	 */
	@Test
	void getPassword() {
		String password = passwordEncoder.encode("1234");
		LOGGER.info("加密后的密码为：{}", password);
	}

	/**
	 * 比较加密前后的密码
	 */
	@Test
	void comparePassword() {
		boolean matches = passwordEncoder.matches("1234", "$2a$10$OIcIDozMTSZG3D2ulZ/u4.qY3p9Fxcte09oplksuaEV9rrTHRHB9a");
		LOGGER.info("两者是否相等: {}", matches);
	}
}
