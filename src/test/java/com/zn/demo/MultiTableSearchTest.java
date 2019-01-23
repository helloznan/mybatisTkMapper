package com.zn.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zn.demo.dao.UserMapper;
import com.zn.demo.model.Role;
import com.zn.demo.model.User;

/**
 * 注解方式实现高级查询
 * @author zhengnan
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiTableSearchTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testMultiSearch(){
		User us = userMapper.searchUserInfo(1L);
		System.out.println(us.getId()+":"+us.getName());
		List<Role> rs = us.getRoles();
		for (Role r : rs) {
			System.out.println("role="+r.getId()+":"+r.getName());
		}
		
	}
	
}
