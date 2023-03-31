package Pages;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage{

    ChromeDriver driver;
    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }
    protected String Url = "https://www.nomobank.com/";

    public String getUrl() {
        return Url;
    }

    public int checkUrlStatus() throws IOException {
        HttpURLConnection c=
                (HttpURLConnection)new
                        URL(Url)
                        .openConnection();
        // set the HEAD request with setRequestMethod
        c.setRequestMethod("HEAD");
        // connection started and get response code
        c.connect();
        int r = c.getResponseCode();
        return r;
    }
}
