package com.studiomediatech.bugs.no_env_in_configprops;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
public class MyConfigurationProperties {

  private List<Property> props = new ArrayList<>();

  public static record Property(String name, int age) {}

  public List<Property> getProps() {
    return props;
  }

  public void setProps(List<Property> properties) {
    this.props = properties;
  }
}
