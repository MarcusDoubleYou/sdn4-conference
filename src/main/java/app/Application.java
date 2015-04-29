package app;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// todo: replace these three with @SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan

@EnableNeo4jRepositories(basePackages = "app.repository")
@EnableTransactionManagement
public class Application extends Neo4jConfiguration{

    private final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Environment env;

    @Override
    @Bean
    public Neo4jServer neo4jServer() {
        log.info("Initialising server connection");
        return new RemoteServer("http://localhost:7474");
    }

    @Override
    @Bean
    public SessionFactory getSessionFactory() {
        log.info("Initialising Session Factory");
        return new SessionFactory(env.getRequiredProperty("domain"));
    }

    @Override
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        log.info("Initialising session-scoped Session Bean");
        return super.getSession();
    }

    /**
     * Main method, used to run the application.
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        app.run(args);
    }

}
