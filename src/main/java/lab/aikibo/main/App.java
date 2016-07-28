package lab.aikibo.main;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;

import org.glassfish.grizzly.http.server.HttpServer;

public class App {
  private static final URI BASE_URI = URI.create("http://localhost:9998/pbb/");

  public static void main(String args[]) {
    try {
      System.out.println("JSON with MOXy Jersey Example PBB App");

      final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
      Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
          server.shutdownNow;
        }
      }));
      server.start();

      System.out.println("Server started. Stop the server using CTRL+C");

      Thread.currentThread().join();
    } catch(IOException | InterruptedException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static ResourceConfig createApp() {
    return new ResourceConfig()
      .packages("lab.aikibo.resource")
      .register(createMoxyJsonResolver());
  }

  public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
    final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
    Map<String, String> namespacePrefixMapper = new HashMap<String, String>();
    namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
    moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(":");
    return moxyJsonConfig.resolver();
  }
}
