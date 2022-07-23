package com.miu.Lab5AOP.repository;

import com.miu.Lab5AOP.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {
}
