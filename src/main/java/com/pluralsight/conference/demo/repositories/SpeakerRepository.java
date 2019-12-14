package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SpeakerRepository extends JpaRepository<Speaker, Long>{
}
