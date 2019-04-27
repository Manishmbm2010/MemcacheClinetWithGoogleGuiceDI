import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.ApplicationBootstrap;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import memcache.MemcacheService;

public class Main {

  public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
    System.setProperty("configFilePath","./src/main/resources/config.json");
    Injector injector = Guice.createInjector();
    injector.getInstance(ApplicationBootstrap.class);
    MemcacheService memcacheService = injector.getInstance(MemcacheService.class);

    String key = "Add Memchace key";
    Object object = memcacheService.retrieveValueByKey(key);
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
  }
}
