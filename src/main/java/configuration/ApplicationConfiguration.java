package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Singleton;
import lombok.Data;

@Data
@Singleton
public class ApplicationConfiguration {

  @JsonProperty("repostoryService")
  private RepositoryConfiguration repositoryConfiguration;

  public ApplicationConfiguration() {
  }

  @Data
  public static class RepositoryConfiguration {

    @JsonProperty("memcache")
    private MemcacheConfiguration memcacheConfiguration;

    @Data
    public static class MemcacheConfiguration {

      @JsonProperty("host")
      String host;
      @JsonProperty("port")
      int port;
    }
  }
}

