package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Xero Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Test Automation Challenge", "Xero");
        extentReports.setSystemInfo("Author", "Yulia Tekin");
        return extentReports;
    }
}