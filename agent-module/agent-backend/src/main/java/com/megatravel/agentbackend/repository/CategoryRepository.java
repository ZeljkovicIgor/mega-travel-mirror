package com.megatravel.agentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.agentbackend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
