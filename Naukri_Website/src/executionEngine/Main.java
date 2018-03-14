package executionEngine;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Main {
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports("E:\\report\\test.html", true);
           
            /*
            // optional
            extent.config()
                .documentTitle("Automation Report")
                .reportName("Regression")
                .reportHeadline("");
               
            // optional
            extent
                .addSystemInfo("Selenium Version", "2.46")
                .addSystemInfo("Environment", "QA"); */
        }
        return extent;
    }
}