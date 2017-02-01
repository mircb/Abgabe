/**
 * Aus Intrernet übernohmen, um Daten herunter zu laden
 *  https://javawebandmore.wordpress.com/2013/03/12/eine-webseite-mit-java-herunterladen-und-speichern/
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;

class WebDownloader{

    public void saveTo(Path targetURL, String path) {
        String content = targetURL.getFileName().toString();

        writeStringToFile(path, content);
    }

    private void writeStringToFile(String filename, String s){
        PrintWriter out = null;
        try {
            out = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.print(s);
        out.close();
    }

    private String getContent(URL targetURL) {
        String line = "";
        String lines = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(targetURL.openStream()));

            while ((line = in.readLine()) != null){
                //System.out.println(line);

                lines = lines+line;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}