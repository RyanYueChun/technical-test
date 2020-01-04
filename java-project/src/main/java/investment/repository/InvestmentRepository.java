package investment.repository;

import investment.models.Investment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InvestmentRepository extends ElasticsearchRepository<Investment, String> {

}
