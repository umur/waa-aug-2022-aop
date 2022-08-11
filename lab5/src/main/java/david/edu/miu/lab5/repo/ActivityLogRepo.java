package david.edu.miu.lab5.repo;

import david.edu.miu.lab5.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaUpdate;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {
}
