import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FileTest.java 2017/03/15 11:17
 */
public class FileTest {
    private static final String getportrait = "http://tb.himg.baidu.com/sys/portrait/item/";

    public static void main(String[] args) {
        String portrait="691c6c7579696c616f73616e4207";
        String urlString = getportrait + portrait;
        String directoryPath = "d:" + File.separator + "portrait";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String fileName = directory + File.separator + portrait;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            byte[] buff = new byte[1024];
            int cnt;
            while ((cnt = inputStream.read(buff)) > 0) {
                baos.write(buff, 0, cnt);
            }
            inputStream.close();
            connection.disconnect();
            baos.close();
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(baos.toByteArray());
            fos.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}