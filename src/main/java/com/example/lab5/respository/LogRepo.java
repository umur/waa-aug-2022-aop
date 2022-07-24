package com.example.lab5.respository;

import com.example.lab5.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepo extends JpaRepository<ActivityLog, Integer> {
}
