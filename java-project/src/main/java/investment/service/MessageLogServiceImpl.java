package investment.service;

import investment.models.MessageLog;
import investment.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class MessageLogServiceImpl implements MessageLogService {

    @Autowired
    MessageLogRepository messageLogRepository;

    @Override
    public Optional<MessageLog> findById(String id) {
        return messageLogRepository.findById(id);
    }

    @Override
    public Iterable<MessageLog> findByMessage(String message) {
        return messageLogRepository.findByMessage(message);
    }

    @Override
    public Iterable<MessageLog> findByTimeStamp(Calendar timeStamp) {
        return messageLogRepository.findByTimeStamp(timeStamp.getTime().toString());
    }

    @Override
    public Iterable<MessageLog> findAll() {
        return messageLogRepository.findAll();
    }

    @Override
    public void save(MessageLog messageLog) {
        messageLogRepository.save(messageLog);
    }

    @Override
    public void deleteById(String id) {
        messageLogRepository.deleteById(id);
    }
}
