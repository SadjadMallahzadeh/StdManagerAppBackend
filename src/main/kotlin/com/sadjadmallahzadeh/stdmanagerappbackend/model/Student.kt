package com.sadjadmallahzadeh.stdmanagerappbackend.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "student")
data class Student(

    @Id
    val name: String,


    val course: String,
    val score: Int
) {
    constructor() : this("", "", -1)
}