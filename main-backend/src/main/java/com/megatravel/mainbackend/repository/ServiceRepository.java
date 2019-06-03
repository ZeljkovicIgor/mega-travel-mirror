package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
