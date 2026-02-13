package chargeUp.dev.repository;

import chargeUp.dev.entity.domain.dao.MethodExecutionTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodExecutionTimeRepository extends CrudRepository<MethodExecutionTime, Long> {
}
