package testdata;

import io.github.sskorol.data.Column;
import io.github.sskorol.data.Sheet;
import lombok.Getter;


@Getter
@Sheet(name = "TESTDATA")
public class TestData {

    @Column(name="TESTCASENAME")
    private String testcasename;

    @Column(name = "BROWSERNAME")
    private String browsername;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "EXECUTE")
    private String execute;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "titlehomepageexpected")
    private String titleHomePageExpected;

    @Column(name = "footertextexpected")
    private String footerTextExpected;

}

