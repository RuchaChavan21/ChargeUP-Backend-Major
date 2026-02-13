package chargeUp.dev.service.accesslog;

import chargeUp.dev.entity.domain.dao.AccessLog;

public interface AccessLogService {
    void save(AccessLog accessLog);
}
