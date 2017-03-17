import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

/**
 * Created by admin on 17.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, MimeTypeParseException {
        URL url = new URL("http://lib.ru");
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        String ct=conn.getHeaderField("Content-Type");
        MimeType mt=new MimeType(ct);
        String cs =mt.getParameter("charset");
        try(InputStream is = conn.getInputStream()){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while (true){
                int c=is.read();
                if(c<0)break;
                bos.write(c);
            }
            System.out.println(bos.toString(cs));
        }
    }

}
