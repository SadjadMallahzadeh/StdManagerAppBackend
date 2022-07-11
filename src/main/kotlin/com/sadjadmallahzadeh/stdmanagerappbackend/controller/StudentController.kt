package com.sadjadmallahzadeh.stdmanagerappbackend.controller

import com.sadjadmallahzadeh.stdmanagerappbackend.model.Student
import com.sadjadmallahzadeh.stdmanagerappbackend.repository.StudentRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class StudentController {

    lateinit var studentRepository: StudentRepository

    @Autowired
    fun set_StudentRepository(studentRepo: StudentRepository) {
        studentRepository = studentRepo
    }

    @GetMapping("/student")
    fun getAllStudents(): ResponseEntity<MutableIterable<Student>> {


        val dataFromDatabase = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"))

        return ResponseEntity.ok(dataFromDatabase)
    }

    @GetMapping("/studentRepoSize")
    fun getStudentRepoSize(): ResponseEntity<Long> {
        return ResponseEntity.ok(studentRepository.count())
    }

    @PostMapping("/student")
    fun insertStudent(@RequestBody data: String): ResponseEntity<ApiRequestResult> {

        val gson = Gson()
        val newStudent = gson.fromJson(data, Student::class.java)
        studentRepository.save(newStudent)
        return ResponseEntity.ok(ApiRequestResult("This message is  from server: Insert is done!"))
    }

    @PutMapping("/student/updating{name}")
    fun updateStudent(@PathVariable("name") name: String, @RequestBody data: String): ResponseEntity<ApiRequestResult> {

        val gson = Gson()
        val newStudent: Student = gson.fromJson(data, Student::class.java)



        studentRepository.save(newStudent)
        return ResponseEntity.ok(ApiRequestResult("This message is  from server: Update is done!"))


    }

    @DeleteMapping("/student/deleting{name}")
    fun deleteStudent(@PathVariable("name") name: String): ResponseEntity<ApiRequestResult> {


        studentRepository.deleteById(name)
        return ResponseEntity.ok(ApiRequestResult("This message is  from server: Delete is done!"))

    }

}