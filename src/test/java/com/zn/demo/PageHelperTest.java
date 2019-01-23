package com.zn.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zn.demo.dao.UserMapper;
import com.zn.demo.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageHelperTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testPageHelper(){
		Page<User> page = PageHelper.startPage(2, 2, true);
		List<User> us = userMapper.selectAll();
		System.out.println(us.size());
		System.out.println(page.getTotal());
	}
}
