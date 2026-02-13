package chargeUp.dev.service.search.response;

import chargeUp.dev.entity.domain.charging.ChargingStation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class SearchResult {
    private final List<ChargingStation> chargingStations;
}
