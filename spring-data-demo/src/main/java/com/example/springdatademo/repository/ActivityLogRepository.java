package com.example.springdatademo.repository;

import com.example.springdatademo.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}
