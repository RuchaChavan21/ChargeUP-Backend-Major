package chargeUp.dev.repository;

import chargeUp.dev.entity.domain.dao.AccessLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLogRepository extends CrudRepository<AccessLog, Long> {
}
