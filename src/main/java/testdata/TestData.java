package testdata;

import io.github.sskorol.data.Column;
import io.github.sskorol.data.Sheet;
import io.github.sskorol.data.Source;


@Sheet(name = "Sheet1")
public class TestData {

    @Column(name="TESTCASENAME")
    public String testcasename;

    @Column(name = "USERNAME")
    public String username;

    @Column(name = "PASSWORD")
    public String password;

    @Column(name = "TITLEHOMEPAGEEXPECTED")
    public String titleHomePageExpected;

    @Column(name = "footerTextExpected")
    public String footerTextExpected;

}
