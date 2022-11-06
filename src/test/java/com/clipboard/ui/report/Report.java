package com.clipboard.ui.report;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private static final Logger logger = LogManager.getLogger(Report.class);
    @Value("${project.name}")
    private String projectName;
    @Value("${report.out.directory}")
    private String reportOutDirectoryPath;
    @Value("${json.out.file}")
    private String jsonFilePath;

    @Autowired
    RemoteWebDriver driver;

    @PreDestroy
    public void generateCucumberReport(){
        logger.info("Preparing Cucumber Report");
        File reportOutDirectory = new File(reportOutDirectoryPath);
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(jsonFilePath);
        Configuration configuration = new Configuration(reportOutDirectory, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
