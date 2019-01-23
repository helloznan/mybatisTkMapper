package com.zn.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zn.demo.model.Role;

@Mapper
public interface RoleMapper {
	
	/**
	 * 多表联合查询，步骤1. 自底向上查询
	 * 
	 * @param userId
	 * @return
	 */
	@Results(id="findById",value={
			@Result(property="id",column="id",id=true),
			@Result(property="name",column="name")
	})
	@Select({"select r.* "
			+ "from role r inner join user_role ur on r.id=ur.role_id "
			+ "where ur.user_id=#{userId} "})
	public List<Role> findAllByUserId(@Param("userId")Long userId);
	
	@Select({"select * from role where id=#{id}"})
	@ResultMap("findById")
	public Role findById(@Param("id") Long id);
}
