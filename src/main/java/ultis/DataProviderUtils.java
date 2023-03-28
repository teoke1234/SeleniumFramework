package ultis;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import testdata.TestData;

import java.lang.reflect.Method;

public final class DataProviderUtils {

    private DataProviderUtils(){}

    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getData(Method m){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("Book1.xlsx")
                .read()
                .filter(testData -> testData.testcasename.equalsIgnoreCase(m.getName()));    }


}
