package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.AccUnavailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccUnavailableRepository extends JpaRepository<AccUnavailable, Long> {
}
