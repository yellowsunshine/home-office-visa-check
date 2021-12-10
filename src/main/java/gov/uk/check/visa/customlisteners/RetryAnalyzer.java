package gov.uk.check.visa.customlisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;


    @Override
    public boolean retry(ITestResult iTestResult) {

        if (retryCount < maxRetryCount){
            retryCount ++;
            return true;
        }
        return false;
    }
}
