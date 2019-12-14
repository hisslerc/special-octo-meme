package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
