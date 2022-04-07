package br.com.felipeaulas.projetoum.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/log")
@RestController
public class LogRESTController {
    @Autowired
    private LogService logService;

    @GetMapping
    public List<LogResponseDTO> findAll(){
        return logService.findAll();
    }
}
