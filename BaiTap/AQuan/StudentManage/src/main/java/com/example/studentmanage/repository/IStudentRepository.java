package com.example.studentmanage.repository;

import com.example.studentmanage.model.Classes;
import com.example.studentmanage.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {
    List<Student> findAllByClasses(Classes classes);
    @Query(value = "select * from students where name like :name", nativeQuery = true)
    List<Student> searchByName(@Param("name") String name);
    List<Student> findAllByOrderByPointAsc();
    List<Student> findAllByOrderByAgeAsc();
}
