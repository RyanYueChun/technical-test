package investment.repository;

import investment.models.MessageLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends ElasticsearchRepository<MessageLog, String> {

    public Iterable<MessageLog> findByMessage(String message);
    public Iterable<MessageLog> findByTimeStamp(String timeStamp);
}
