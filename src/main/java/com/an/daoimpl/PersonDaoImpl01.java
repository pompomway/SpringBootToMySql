package com.an.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.an.utils.Person;
@Component 
public class PersonDaoImpl01 extends PersonDaoImpl {

	@Override
	public List<Person> getById(JdbcTemplate jt, String... id) {
		List<Person> list =new ArrayList<>();
		RowMapper<Person>rowMap=new BeanPropertyRowMapper<>(Person.class);
		for(String idd:id) {
			String sql="select * from login where id=?;";
			List<Person> getList=jt.query(sql, rowMap,idd);
			getList.forEach(x->list.add(x));
		}
		return list;
	}

	@Override
	public List<Person> getByPass(JdbcTemplate jt, String... pass) {
		List<Person> list =new ArrayList<>();
		RowMapper<Person>rowMap=new BeanPropertyRowMapper<>(Person.class);
		for(String pas:pass) {
			String sql="select * from login where pass=?;";
			List<Person> getList=jt.query(sql, rowMap,pas);
			getList.forEach(x->list.add(x));
		}
		return list;
	}

}
