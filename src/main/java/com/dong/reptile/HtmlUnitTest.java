import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * script标签获取不到的情况下
 */
public class HtmlUnitTest {
    public static void main(String[] args) {
        String url ="http://www.qidian.com";
        url = "http://www.nffund.com/main/xxpl/index.shtml";
        // 1创建WebClient
        WebClient webClient=new WebClient(BrowserVersion.CHROME);
        // 2 启动JS
        webClient.getOptions().setJavaScriptEnabled(true);
        // 3 禁用Css，可避免自动二次請求CSS进行渲染
        webClient.getOptions().setCssEnabled(false);
        // 4 启动客戶端重定向
        webClient.getOptions().setRedirectEnabled(true);
        // 5 js运行错誤時，是否拋出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        // 6 设置超时
        webClient.getOptions().setTimeout(50000);       //获取网页
        HtmlPage htmlPage = null;
        try {
            htmlPage = webClient.getPage(url);
        } catch (FailingHttpStatusCodeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 等待JS驱动dom完成获得还原后的网页
        webClient.waitForBackgroundJavaScript(10000);
        // 网页内容
        String pageHtml = htmlPage.asXml();
        System.out.println(pageHtml);
        System.out.println("\n------\n");
        //网页内容---纯文本形式
        String pageText = htmlPage.asText();
        System.out.println(pageText );

        //输出网页的title
        String title = htmlPage.getTitleText();
        System.out.println(title );

        //close
        webClient.close();
    }
}