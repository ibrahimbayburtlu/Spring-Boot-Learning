package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
// The object that will be persistent in the database is called Entity.

// Nesnenin entity sayılabilmesi ve veritabanı tarafından tanınılabilmesi için class tanımının hemen üstünde @Entity annotation tanımlanmalıdır.
// Table annotation sayesinde tablomuza isim verebiliriz. @Table(name="MY_STUDENT")
@Entity
@Table
public class Student {
    // Bu annotation ile POJO sınıfındaki bir değişkenin Id alanı ne olduğunu belirtiriz. Id alanı veritabanı tablsounda bir primary key veya Identity alanına karşılık gelmektedir.
    // POJO sınıfı Plain Old Java Object => ir java sınıfının bir başka sınıf ile extends,implements gibi bağlantılarını yapılmamış,constructor oluşturulmamış ve belirtimler kullanılmamış halidir.
    @Id
    // Sequence => Yeni bir kayıt listesi
    // @SequenceGenerator notasyonu ile bir Sequence oluşturuyoruz.
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    // @GeneratedValue => biz her seferinde yeni bir kayıt eklediğimizde manual olarak "id" vermemize gerek kalmıyor auto olarak kendi her kayıt için bir "id" oluşturuyor.
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
