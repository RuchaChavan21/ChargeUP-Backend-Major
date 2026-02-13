package chargeUp.dev.service.chargingstationdetail.template.provider.epdk;

import chargeUp.dev.entity.enums.ChargingProvider;
import chargeUp.dev.service.chargingstationdetail.template.ChargingStationDetailTemplate;
import chargeUp.dev.service.search.SearchService;
import org.springframework.stereotype.Component;

@Component
public class EPDKChargingStationDetailService extends ChargingStationDetailTemplate {
    public EPDKChargingStationDetailService(SearchService service) {
        super(service);
    }

    @Override
    protected ChargingProvider getChargingProvider() {
        return ChargingProvider.EPDK;
    }

    @Override
    protected boolean requireProviderRelated() {
        return false;
    }

    @Override
    protected String resolveProviderChargingStationId(String chargingStationId) {
        return chargingStationId;
    }
}
