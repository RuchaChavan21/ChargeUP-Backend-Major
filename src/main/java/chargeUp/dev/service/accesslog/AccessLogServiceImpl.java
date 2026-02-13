package chargeUp.dev.service.accesslog;

import chargeUp.dev.entity.domain.dao.AccessLog;
import chargeUp.dev.repository.AccessLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccessLogServiceImpl implements AccessLogService {

    private final AccessLogRepository accessLogRepository;

    @Override
    public void save(AccessLog accessLog) {
        accessLogRepository.save(accessLog);
    }
}
