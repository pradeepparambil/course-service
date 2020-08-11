package com.teksenz.courseservice.repositories;

import com.teksenz.courseservice.domain.FeePaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeePaymentScheduleRepository extends JpaRepository<FeePaymentSchedule, UUID> {
}
