package com.zn.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zn.demo.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
	@Select("select * from user")
	List<User> findAll();
	
	@Select("select * from user where id=#{id}")
	User findById(@Param("id") Long id);
	
	
	/*
	 * id=true:对映xml的<id>元素
	 * 
	 */
	@Results(id="userBaseInfo",value={
		@Result(property="id",column="id",id=true),
		@Result(property="name",column="name"),
		/*
		 * 1.将查询列表的行为委托给其他方法
		 * 2.column将本次主查询的值作为参数传给子查询 
		 */
		@Result(property="roles",javaType=List.class,column="id",many=@Many(select="com.zn.demo.dao.RoleMapper.findAllByUserId"))
	})
	@Select({"select * "
			+ "from user  "
			+ "where id=#{id}"})
	User searchUserInfo(@Param("id")Long id);
}
