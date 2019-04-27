package memcache;

import com.google.inject.Inject;
import configuration.ApplicationConfiguration;
import java.io.IOException;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;

public class MemcacheClient {

  private final MemcachedClient client;

  @Inject
  private MemcacheClient(ApplicationConfiguration applicationConfiguration) throws IOException {
    String host = applicationConfiguration.getRepositoryConfiguration().getMemcacheConfiguration().getHost();
    int port = applicationConfiguration.getRepositoryConfiguration().getMemcacheConfiguration().getPort();
    client = new MemcachedClient(new ConnectionFactoryBuilder()
        .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).build(),
        AddrUtil.getAddresses(new StringBuilder(host).append(":").append(port).toString()));

  }

  public MemcachedClient getClient() {
    return client;
  }
}
