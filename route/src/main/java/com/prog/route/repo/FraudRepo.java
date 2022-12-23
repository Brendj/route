package com.prog.route.repo;

import com.prog.route.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<Fraud, Long> {
    Fraud findByName(String name);
}
