package edu.miu.waaaug2022aop.repository;

import edu.miu.waaaug2022aop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}
