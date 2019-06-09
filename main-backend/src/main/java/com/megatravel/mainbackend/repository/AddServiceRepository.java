package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.AddService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface AddServiceRepository extends JpaRepository<AddService, Long> {
}
