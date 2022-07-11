package com.sadjadmallahzadeh.stdmanagerappbackend.repository

import com.sadjadmallahzadeh.stdmanagerappbackend.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository:CrudRepository<Student,String>,JpaRepository<Student,String> {



}