package chargeUp.dev.service.methodexecutiontime;

import chargeUp.dev.core.aspect.performance.ElapsedType;
import chargeUp.dev.core.aspect.performance.Performance;
import chargeUp.dev.entity.domain.dao.MethodExecutionTime;
import chargeUp.dev.repository.MethodExecutionTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Performance(value = ElapsedType.SERVICE_ELAPSED, exclude = true)
public class MethodExecutionTimeServiceImpl implements MethodExecutionTimeService {

    private final MethodExecutionTimeRepository methodExecutionTimeRepository;

    @Override
    public void save(MethodExecutionTime executionTime) {
        methodExecutionTimeRepository.save(executionTime);
    }
}
