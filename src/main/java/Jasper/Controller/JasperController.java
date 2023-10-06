package Jasper.Controller;

import Jasper.Service.JasperService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class JasperController {
    @Autowired
    JasperService jasperService;
    @GetMapping("/getReport/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return jasperService.getDataReport(format);

    }
}
