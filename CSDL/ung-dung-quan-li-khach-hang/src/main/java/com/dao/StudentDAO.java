package com.dao;

import com.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> loadStudent();
}
