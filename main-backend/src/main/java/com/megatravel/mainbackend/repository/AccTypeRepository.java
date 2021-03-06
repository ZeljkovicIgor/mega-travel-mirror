package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.AccType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccTypeRepository extends JpaRepository<AccType, Long> {
}
