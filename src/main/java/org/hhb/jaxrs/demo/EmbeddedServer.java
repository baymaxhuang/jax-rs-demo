package org.hhb.jaxrs.demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public final class EmbeddedServer {

  public static void main(String[] args) throws Exception {
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    int port = 8080;
    if(args.length >= 1) {
      port = Integer.parseInt(args[0]);
    }

    Server jettyServer = new Server(port);
    jettyServer.setHandler(context);

    ServletHolder jerseyServlet = context.addServlet(
            ServletContainer.class, "/*");
    jerseyServlet.setInitOrder(0);

    // Tells the Jersey Servlet which REST service/class to load.
    jerseyServlet.setInitParameter(
            "jersey.config.server.provider.classnames",
            DemoResource.class.getCanonicalName());

    try {
      jettyServer.start();
      jettyServer.join();
    } finally {
      jettyServer.destroy();
    }
  }
}
