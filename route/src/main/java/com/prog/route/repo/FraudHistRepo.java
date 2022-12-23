package com.prog.route.repo;

import com.prog.route.model.FraudHist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudHistRepo extends JpaRepository<FraudHist, Long> {
}
