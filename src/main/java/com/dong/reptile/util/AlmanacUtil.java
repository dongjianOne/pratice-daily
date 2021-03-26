import com.dong.reptile.Information;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AlmanacUtil {

    public AlmanacUtil() {

    }
    //获得源码
    public String getdata(String url) {
        String data = null;
        org.apache.commons.httpclient.HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("User_Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());//系统默认的恢复策略
        try {
            int statusCode = client.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Wrong");
            }
            byte[] responseBody = getMethod.getResponseBody();
            data = new String(responseBody);
            return data;

        } catch (HttpException e) {
            System.out.println("Please check your provided http address!");
            data = "";
            e.printStackTrace();

        } catch (IOException e) {
            data = "";
            e.printStackTrace();
        } finally {

            getMethod.releaseConnection();

        }
        return data;
    }

    //想要获取字段部分的分割模式
    static Pattern proInfo = Pattern.compile("<td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td>" +
            "<td>(.*?)</td><td>(.*?)</td>", Pattern.DOTALL);

    private static List<Information> getDataStructure(String str) {
        //想要获取的整段数据的分割模式
        String[] info = str.split("</tr>");
        List<Information> list = new ArrayList<Information>();
        for (String s : info) {
            Matcher m = proInfo.matcher(s);
            Information information = null;
            if (m.find()) {
                information = new Information();
                String ss = m.group(1).trim();
                information.setType(ss);
                information.setVolume(m.group(2).trim());
                information.setMoney(m.group(3).trim());
                information.setMarket_value(m.group(4).trim());
                information.setNumber(m.group(6).trim());
                information.setPrice_earnings_ratio(m.group(7).trim());
                list.add(information);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        AlmanacUtil almanacUtil = new AlmanacUtil();
        String ss = almanacUtil.getdata("http://www.nffund.com/main/xxpl/index.shtml");
        List<Information> list = getDataStructure(ss);
        String string = "";
        for (int k = 0; k < list.size(); k++) {
            String s = "类别：" + list.get(k).getType() + " " + "成交量：" + list.get(k).getVolume() + " " +
                    "成交金额：" + list.get(k).getMoney() + " " + "总市值：" + list.get(k).getMarket_value() +
                    " " + "上市公司（家）:" + list.get(k).getNumber() + " " + "平均市盈率：" + list.get(k).getPrice_earnings_ratio() + "\n";
            string = string + s;
        }
        System.out.println(string);
        File f = new File("D:" + File.separator + "gupiao.txt");//存在D盘guipiao.txt里
        OutputStream out = null;
        out = new FileOutputStream(f);
        byte b[] = string.getBytes();
        out.write(b);
        out.close();
    }
}
