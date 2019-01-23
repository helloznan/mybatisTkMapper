package com.zn.demo;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zn.demo.dao.RoleMapper;
import com.zn.demo.dao.UserMapper;
import com.zn.demo.model.Role;
import com.zn.demo.model.User;

/**
 * 测试注解方式查询
 * @author zhengnan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void contextLoads() {
		List<User> us = userMapper.findAll();
		for (User u : us) {
			System.out.println(u.getId()+":"+u.getName());
		}
	}
	
	@Test
	public void testFindById(){
		User ur = userMapper.findById(1L);
		System.out.println(ur.getName()+"=====");
	}
	
	@Test
	public void testFindRole(){
		System.out.println("查询角色信息====");
		Role r = roleMapper.findById(1L);
		System.out.println("角色1的信息==="+r.getId()+":"+r.getName());
	}
	
	@Test
	public void testFindAllRoleByUserId(){
		System.out.println("testFindAllRoleByUserId=====");
		List<Role> rs = roleMapper.findAllByUserId(1L);
		for (Role r : rs) {
			System.out.println(r.getId()+":"+r.getName());
		}
		System.out.println("testFindAllRoleByUserId=====");
	}
	
}

