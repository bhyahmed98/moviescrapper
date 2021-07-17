package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import com.example.demo.model.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {
=======
import com.example.demo.model.Actor;
import com.example.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>
{
>>>>>>> 9ab70f20c7678094e29a9477fea993e3365ce501

}
