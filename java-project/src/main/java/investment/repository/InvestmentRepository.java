package investment.repository;

import investment.models.Investment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface InvestmentRepository extends ElasticsearchRepository<Investment, String> {
        List<Investment> findByCityIgnoreCase(@Nullable String city);
        List<Investment> findByAdvancementStateIgnoreCase(@Nullable String advancementState);
        List<Investment> findByCityAndAdvancementStateAllIgnoreCase(@Nullable String city, @Nullable String advancementState);
}
