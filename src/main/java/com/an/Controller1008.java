package com.an;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.an.dao.PersonDao;
import com.an.utils.Person;
@Controller
public class Controller1008 {
  @Autowired
  JdbcTemplate jt;
  @Autowired
  PersonDao dao;
  @Autowired
  Person pn;
  
  @GetMapping("/an")
  public String getIndex() {
	  pn=new Person(34,"root1008","123456");
	  System.out.println(dao.delete(jt, 34));
	  List<Person>list=dao.getByPass(jt, "123456","654321");
	  list.forEach(x->print(x));
	  //System.out.println(dao.update(jt, pn));
	  return "index";
  }
  
  private void print(Person pn) {
	  int pk=pn.getPk();
	  String id=pn.getId();
	  String pass=pn.getPass();
	  if(pk==0) {
		  if(id==null) {
			  System.out.println("No Data!");
			  System.out.println("-----------");
		  }else {
			  System.out.println("ID  :"+id);
			  System.out.println("Pass:"+pass);
			  System.out.println("-----------");
		  }
	  }else {
		  System.out.println("Pk  :"+pk);
		  System.out.println("ID  :"+id);
		  System.out.println("Pass:"+pass);
		  System.out.println("-----------");
	  }
  }
}
