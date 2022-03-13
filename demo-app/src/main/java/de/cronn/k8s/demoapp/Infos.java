package de.cronn.k8s.demoapp;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Infos {

  private String hostname;

  private Map<String, String> envVars;

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public Map<String, String> getEnvVars() {
    return envVars;
  }

  public void setEnvVars(Map<String, String> envVars) {
    this.envVars = envVars;
  }

  @Override
  public String toString() {
    return "Infos{" +
        "hostname='" + hostname + '\'' +
        ", envVars=" + envVars +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Infos infos = (Infos) o;
    return Objects.equals(hostname, infos.hostname) &&
        Objects.equals(envVars, infos.envVars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, envVars);
  }
}
