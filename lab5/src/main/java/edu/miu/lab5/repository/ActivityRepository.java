package edu.miu.lab5.repository;

import edu.miu.lab5.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<ActivityLog,Integer> {

}
