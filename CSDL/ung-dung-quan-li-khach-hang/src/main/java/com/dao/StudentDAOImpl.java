package com.dao;

import com.model.Student;
import com.rowmapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> loadStudent() {
        String sql = "select * from students";
        List<Student> theListOfStudent = jdbcTemplate.query(sql,new StudentRowMapper());
        return theListOfStudent;
    }
}
