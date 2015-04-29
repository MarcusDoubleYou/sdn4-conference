package generate;

import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: Vince Bickers
 */
public class Generate {

    private static String entity_root = "src/main/webapp/scripts/app/entities/";
    private static String navbar_file = "src/main/webapp/scripts/components/navbar/navbar.html";
    private static String webapp_file = "src/main/webapp/index.html";


    private static final String[] entities = new String[] {
            "attendee",
            "conference",
            "room",
            "session",
            "speaker",
            "topic",
            "track",
            "venue"
    };

    public void generate() {

        generateIndexPage();
        generateNavBar();

        for (String name : entities) {
            generateEntity(name);
        }
    }

    private void generateNavBar() {
        System.out.println("generating navbar");

        String navbar = readFile("src/main/resources/navbar.html", Charset.forName("UTF-8"));
        String navbarItem = readFile("src/main/resources/navbar-item.html", Charset.forName("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (String name : entities) {
            sb.append(replace(navbarItem, name));
        }

        writeFile(navbar_file, navbar.replace("{$entities}", sb.toString()));

    }

    private void generateIndexPage() {
        System.out.println("generating index page");

        String index = readFile("src/main/resources/index.html", Charset.forName("UTF-8"));
        String include = readFile("src/main/resources/include-scripts.html", Charset.forName("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (String name : entities) {
            sb.append(replace(include, name));
        }
        writeFile(webapp_file, index.replace("{$entities}", sb.toString()));

    }

    private void generateEntity(String name) {
        System.out.println("generating entity : " + name);
        createFolder(name);
        writeEntity("config.js", name);
        writeEntity("controllers.js", name);
        writeEntity("servicefactory.js", name);
        writeEntity("list.html", name);
        writeEntity("detail.html", name);
    }

    private void createFolder(String name) {
        try {
            Files.createDirectories(Paths.get(".", entity_root + name));
        }
        catch (FileAlreadyExistsException faee) {
            ;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeEntity(String source, String name) {
        String content = readFile("src/main/resources/template." + source, Charset.forName("UTF-8"));
        writeFile(entity_root + name + "/" + source, replace(content, name));

    }

    private String replace(String content, String name) {
        String lc = name;
        String uc = name.substring(0, 1).toUpperCase().concat(name.substring(1));
        return content.replace("{$}", lc).replace("{$$}", uc) ;
    }


    private String readFile(String path, Charset encoding) {
        try {
            //File file = new File(getClass().getClassLoader().getResource(path).getFile());
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, encoding);
        } catch (Exception ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private void writeFile(String name, String contents) {

        try {
            Files.write(Paths.get(".", name), contents.getBytes(Charset.forName("UTF-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        new Generate().generate();
//    }
}
