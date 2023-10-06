package Jasper.Service;

import Jasper.Entity.JasperEntity;
import Jasper.Repository.JasperRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class JasperService {
    @Autowired
    private JasperRepo jasperRepo;

    public String getDataReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\NON-CURAM\\Report";
        List<JasperEntity> emailList = jasperRepo.findAll();
        //Load file
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        //to compile file
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        //to get the  data to make the report
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(emailList);
        Map<String, Object> map = new HashMap<>();
        map.put("createdBy", "XYZ");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);

        //will checkif paramter has html/pdf type document
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");

        }

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }

        return "Report generated";

    }
}
