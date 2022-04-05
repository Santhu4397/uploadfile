package com.ty.uploadfile.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.uploadfile.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
