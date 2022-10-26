package com.an.daoimpl;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.an.dao.PersonDao;
import com.an.utils.Person;

public abstract class PersonDaoImpl implements PersonDao{

	@Override
	public int save(JdbcTemplate jt, Person pn) {
		String sql="insert into login (id,pass)value(?,?);";
		return jt.update(sql,pn.getId(),pn.getPass());
	}

	@Override
	public int update(JdbcTemplate jt, Person pn) {
		String sql="update login set pass=? where pk=?;";
		return jt.update(sql,pn.getPass(),pn.getPk());
	}

	@Override
	public int delete(JdbcTemplate jt, int pk) {
		String sql="delete from login where pk=?;";
		return jt.update(sql,pk);
	}

	@Override
	public Person getByPk(JdbcTemplate jt, int pk) {
		String sql="select id,pass from login where pk=?;";
		Person pn=new Person();
		try {
			RowMapper<Person> rowMap=new BeanPropertyRowMapper<>(Person.class);
			pn=jt.queryForObject(sql, rowMap,pk);
		} catch (Exception e) {
			System.out.println("getByPk error!");
		}
		return pn;
	}
	


}
