package chargeUp.dev.service.elasticsearch.settings;

import chargeUp.dev.core.elasticsearch.settings.ElasticSearchIndicesService;
import chargeUp.dev.core.file.ResourceFileContentReader;
import chargeUp.dev.service.elasticsearch.indexer.template.ElasticSearchIndexerTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static chargeUp.dev.common.Constant.Elastic.*;

@Component
@AllArgsConstructor
public class ElasticSearchIndicesSettingsServiceImpl implements ElasticSearchIndicesSettingsService {
    private final ResourceFileContentReader resourceFileContentReader;
    private final ElasticSearchIndicesService elasticSearchIndicesService;

    private final List<ElasticSearchIndexerTemplate<?>> elasticSearchIndexer;

    @Override
    public void rotateChargingStationsIndex() {
        String settings = resourceFileContentReader
                .readResourceFileAsStream(ES_INDEX_SETTINGS_RESOURCE_PATH)
                .orElseThrow(IllegalArgumentException::new);

        String mappings = resourceFileContentReader
                .readResourceFileAsStream(ES_INDEX_MAPPINGS_RESOURCE_PATH)
                .orElseThrow(IllegalArgumentException::new);

        String indexName = createIndexName();

        Runnable afterIndexHook = () -> elasticSearchIndexer.parallelStream().forEach(ElasticSearchIndexerTemplate::index);

        elasticSearchIndicesService.create(indexName, ES_INDEX_ALIAS_NAME, settings, mappings, afterIndexHook);
    }

    private String createIndexName() {
        String formattedDateTİme = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));

        return ES_INDEX_ALIAS_NAME + "_" + formattedDateTİme;
    }
}
