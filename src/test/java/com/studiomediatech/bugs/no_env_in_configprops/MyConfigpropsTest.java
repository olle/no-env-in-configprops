package com.studiomediatech.bugs.no_env_in_configprops;

import static org.assertj.core.api.Assertions.assertThat;

import com.studiomediatech.bugs.no_env_in_configprops.MyConfigurationProperties.Property;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.context.runner.ContextConsumer;
import org.springframework.context.annotation.Configuration;

public class MyConfigpropsTest {

  @Test
  void mustCreatePropertyListFromSystemProperties() {
    configuredApplicationContextRunner()
        .withSystemProperties(
            "MY_PROPS_0_NAME=Fred", "MY_PROPS_0_AGE=44", "MY_PROPS_1_NAME=Joe", "MY_PROPS_1_AGE=22")
        .run(assertFred44AndJoe22AreInPropertyList());
  }

  @Test
  void mustCreatePropertyListFromPropertyValues() throws Exception {
    configuredApplicationContextRunner()
        .withPropertyValues(
            "my.props[0].name=Fred",
            "my.props[0].age=44",
            "my.props[1].name=Joe",
            "my.props[1].age=22")
        .run(assertFred44AndJoe22AreInPropertyList());
  }

  private ApplicationContextRunner configuredApplicationContextRunner() {
    return new ApplicationContextRunner().withUserConfiguration(TestConfiguration.class);
  }

  private ContextConsumer<AssertableApplicationContext> assertFred44AndJoe22AreInPropertyList() {
    return ctx ->
        assertThat(ctx.getBean(MyConfigurationProperties.class).getProps())
            .containsExactly(new Property("Fred", 44), new Property("Joe", 22));
  }
}

@Configuration
@EnableConfigurationProperties(MyConfigurationProperties.class)
class TestConfiguration {}
