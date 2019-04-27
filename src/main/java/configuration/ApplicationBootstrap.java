package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ApplicationBootstrap {

  private final ApplicationConfiguration applicationConfiguration;

  @Inject
  public ApplicationBootstrap(ApplicationConfiguration applicationConfiguration) throws IOException {
    String path = "./src/main/resources/config.json";
    String configString = new String(Files.readAllBytes(Paths.get(path)));
    ObjectMapper objectMapper = new ObjectMapper();
    Map configMap = objectMapper.readValue(configString, Map.class);
    this.applicationConfiguration = objectMapper.convertValue(configMap, ApplicationConfiguration.class);
    applicationConfiguration.setRepositoryConfiguration(this.applicationConfiguration.getRepositoryConfiguration());
  }
}
