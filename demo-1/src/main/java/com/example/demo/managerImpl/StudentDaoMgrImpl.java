package com.example.demo.managerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.Student;
import com.example.demo.manager.IStudentDaoMgr;


@Component
public class StudentDaoMgrImpl implements IStudentDaoMgr {
	
	@Autowired
	private JdbcTemplate jdbcTmplate;

	@Override
	public <S extends Student> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Student> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Student> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Student> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findByName(String name) {
		
		return null;
	}

	@Override
	public List<Student> findAllStu() {
		List<Map<String,Object>> queryForList = jdbcTmplate.queryForList("select * from STUDENT");
		List<Student> list = new ArrayList<>();
		for (Map<String, Object> map : queryForList) {
			Student stu = new Student();
			stu.setId(Integer.valueOf(map.get("ID").toString()));
			stu.setName(map.get("NAME").toString());
			list.add(stu);
		}
		return list;
	}

}
