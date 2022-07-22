package waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.entity.ActivityLog;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
