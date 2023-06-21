package com.example.studentmanage.repository;

import com.example.studentmanage.model.Classes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends PagingAndSortingRepository<Classes, Long> {
}
