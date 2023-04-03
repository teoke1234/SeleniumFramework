package config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/Config/config.properties")
public interface FrameworkConfig extends Config {

    long timeout();
    String url();
    String runmode();
    String remoteurl();
    String passStepsScreenshot();
}
