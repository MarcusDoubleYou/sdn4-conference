package app.service;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class ImportService {

    @Autowired
    private Session session;

    public void reload(String cqlFile) {
        session.purgeDatabase();
        session.execute(load(cqlFile));
    }

    protected static String load(String cqlFile) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(cqlFile)));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }



}
