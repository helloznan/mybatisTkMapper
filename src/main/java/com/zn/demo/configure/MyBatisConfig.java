package com.zn.demo.configure;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.pagehelper.PageHelper;


@Configuration
public class MyBatisConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		
		//设置数据源,从properties中读取
		String url="jdbc:mysql://localhost:3306/mybatisTkMapper";
		String username="root";
		String password="admin";
		String driver="com.mysql.cj.jdbc.Driver";
		DataSource dataSource =new PooledDataSource(driver,url,username,password);
		bean.setDataSource(dataSource);
		
		bean.setTypeAliasesPackage("com.zn.demo");
		
		//分页插件设置
		PageHelper ph=new PageHelper();
		Properties p = new Properties();
		p.setProperty("reasonable", "true");
		p.setProperty("supportMethodsArguments", "true");
		p.setProperty("returnPageInfo", "check");
		p.setProperty("params", "count=countSql");
		ph.setProperties(p);
		
		//添加分页插件
		bean.setPlugins(new Interceptor[]{ph});
	 
//	    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    try {
	        //基于注解扫描Mapper，不需配置xml路径
	        //bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
	        return bean.getObject();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }

	}
}
