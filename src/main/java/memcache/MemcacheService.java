package memcache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import java.util.concurrent.ExecutionException;

public class MemcacheService {

  private final MemcacheClient memcacheClient;

  @Inject
  public MemcacheService(MemcacheClient memcacheClient) {
    this.memcacheClient = memcacheClient;
  }

  public Object retrieveValueByKey(String key) throws JsonProcessingException, ExecutionException, InterruptedException {
   /* boolean dataCached = memcacheClient.getClient().set("foo", 0, "bar").get();
    System.out.println(dataCached);*/
    Object object = memcacheClient.getClient().get(key);
    return object;
  }
}
