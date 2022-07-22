package miu.edu.lab05.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab05.models.ActivityLog;
import miu.edu.lab05.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService{
    private final ActivityLogRepository repository;
    @Override
    public List<ActivityLog> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ActivityLog> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return repository.save(activityLog);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
