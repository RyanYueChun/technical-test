package investment.service;

import investment.models.MessageLog;

import java.util.Calendar;
import java.util.Optional;

public interface MessageLogService {
    Optional<MessageLog> findById(String id);
    Iterable<MessageLog> findByMessage(String message);
    Iterable<MessageLog> findByTimeStamp(Calendar timeStamp);
    Iterable<MessageLog> findAll();
    void save(MessageLog messageLog);
    void deleteById(String id);
}
