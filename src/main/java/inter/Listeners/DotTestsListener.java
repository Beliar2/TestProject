package inter.Listeners;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class DotTestsListener extends TestListenerAdapter{
    private int counter = 0;

    @Override
    public void onTestFailure(ITestResult tr) {
        log("F");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("S");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log(".");
    }

    public void log(String string) {
        System.out.println(string);
        if (++counter % 40 ==0) {
            System.out.println("");
        }
    }


}
