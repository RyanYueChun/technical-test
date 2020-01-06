package investment.controller;

import investment.models.MessageLog;
import investment.service.MessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message-logs")
public class MessageLogController {

    @Autowired
    MessageLogService messageLogService;

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public Iterable<MessageLog> getAllMessageLogs() {
        return messageLogService.findAll();
    }
}
