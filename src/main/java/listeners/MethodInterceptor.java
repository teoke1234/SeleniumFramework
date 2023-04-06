package listeners;

import constants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import ultis.ExcelUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmangersheet());
        List<IMethodInstance> result = new ArrayList<>();

        for(int i=0;i<methods.size();i++) {
            for(int j=0;j<list.size();j++) {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TESTCASENAME")) &&
                        list.get(j).get("execute").equalsIgnoreCase("yes")) {
                    methods.get(i).getMethod().setDescription(list.get(j).get("test description"));
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                    methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                    methods.get(i).getMethod().setPriority(1);
                    result.add(methods.get(i));
                }
            }
        }
        return result;
    }
}
