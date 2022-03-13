package de.cronn.k8s.demoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class InfoController {

  public static final String ENV_PREFIX = "CRONN";

  @RequestMapping("/infos")
  public Infos getInfos() throws UnknownHostException {
    Infos infos = new Infos();
    infos.setHostname(Inet4Address.getLocalHost().getHostName());

    Map<String, String> envs = System.getenv().entrySet().stream()
        .filter(envEntry -> envEntry.getKey().startsWith(ENV_PREFIX))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    infos.setEnvVars(envs);

    return infos;
  }
}
