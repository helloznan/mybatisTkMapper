package com.zn.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.jdbc.Driver;
import com.zn.demo.dao.UserMapper;
import com.zn.demo.model.User;

/**
 * 通用mapper查询
 * @author zhengnan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperMapperTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testFindAll(){
		List<User> us =userMapper.selectAll();
		for (User u : us) {
			System.out.println(u.getId()+":"+u.getName());
			System.out.println("role===用通用mapper无法查询到子属性数据："+u.getRoles());
			
		}
	}
}
