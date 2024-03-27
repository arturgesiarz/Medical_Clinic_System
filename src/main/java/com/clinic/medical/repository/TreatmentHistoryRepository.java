package com.clinic.medical.repository;

import com.clinic.medical.model.TreatmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentHistoryRepository extends JpaRepository<TreatmentHistory, Long> {
}
