package br.com.felipeaulas.projetoum.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {
@Autowired
private LogRepository logRepository;


    public List<LogResponseDTO> findAll() {
        return logRepository.findAll().stream().map(LogResponseDTO::convertFromEntity).collect(Collectors.toList());
    }

    public void createLog(String whoDo, LogAction action, String description) {
        Log log = new Log(whoDo, action, description);
        logRepository.save(log);
    }
}
