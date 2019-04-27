import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.ApplicationBootstrap;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import memcache.MemcacheService;

public class Main {

  public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
    Injector injector = Guice.createInjector();
    injector.getInstance(ApplicationBootstrap.class);
    MemcacheService memcacheService = injector.getInstance(MemcacheService.class);

    String key = "346375099180776:NET_MINING-zmjjzgjhmtu4m";
    Object object = memcacheService.retrieveValueByKey(key);
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
  }
}
