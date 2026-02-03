package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
        // prevent external instantiation
    }

    public static ExtentReports getInstance() {
        if (extent == null) {
        	
        	//Generating date
        	String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        	
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport" +"_"+ timeStamp+".html");

            spark.config().setReportName("Cholickal Automation Test Results");
            spark.config().setDocumentTitle("Cholickal Selenium Extent Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Dhanesh S");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}

