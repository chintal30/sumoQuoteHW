package com.sumoQuote.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sumoQuote.utilities.CommonUtils;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent-report"+ CommonUtils.getCurrentDateTime()+".html");
      //  ExtentSparkReporter reporter = new ExtentSparkReporter("reports/SparkActimePlugin.html");
        reporter.config().setReportName("Extent_Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company Name", "SumoQuote");
        extentReports.setSystemInfo("Author", "QA automation team");
        return extentReports;
    }
}
