package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;

import com.atguigu.bean.Person;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类

@ComponentScans(
		value = {
				@ComponentScan(value="com.atguigu",includeFilters = {
/*						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
						@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
				},useDefaultFilters = false)	
		}
		)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {
	
	@Scope(value = "prototype") //配置多例，IOC容器启动时不创建多实例bean对象，获取对象时才创建
	@Bean //给容器中注册一个bean,id默认=方法名,也可以@Bean("person")指定id,class=方法返回值类型.
	public Person person() {
	return new Person("Tom", 20);
	}

	@Lazy //单实例bean默认在IOC容器启动时创建,懒加载表示容器启动不创建bean对象,而是在第一次获取使用bean时创建
	@Bean
	public Person p() {
	return new Person("Jack", 18);
	}

}
