package cn.zzh.chatbot.api.test;

import io.github.bonigarcia.wdm.online.HttpClient;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        //创建链接
        CloseableHttpClient httpClient =HttpClientBuilder.create().build();
        HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/48884182255828/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=6D9F81D7-6268-332D-87BF-1405B79B1C11_8DD6016ECE2DEEAD; abtest_env=product; zsxqsessionid=e1ee09e90bcbb439dd4baa28ab68d8ab; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218b84ca4f4812a7-0eaf295e0ad0df8-745d5777-1821369-18b84ca4f491adb%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiODRjYTRmNDgxMmE3LTBlYWYyOTVlMGFkMGRmOC03NDVkNTc3Ny0xODIxMzY5LTE4Yjg0Y2E0ZjQ5MWFkYiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218b84ca4f4812a7-0eaf295e0ad0df8-745d5777-1821369-18b84ca4f491adb%22%7D; sajssdk_2015_cross_new_user=1");
        get.addHeader("Content_Type","application/json, text/plain, */*");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res =EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

@Test
    public void answer() throws IOException {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    //处理post请求
    HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/211222848252811/answer");
    post.addHeader("cookie","zsxq_access_token=6D9F81D7-6268-332D-87BF-1405B79B1C11_8DD6016ECE2DEEAD; abtest_env=product; zsxqsessionid=e1ee09e90bcbb439dd4baa28ab68d8ab; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218b84ca4f4812a7-0eaf295e0ad0df8-745d5777-1821369-18b84ca4f491adb%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiODRjYTRmNDgxMmE3LTBlYWYyOTVlMGFkMGRmOC03NDVkNTc3Ny0xODIxMzY5LTE4Yjg0Y2E0ZjQ5MWFkYiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218b84ca4f4812a7-0eaf295e0ad0df8-745d5777-1821369-18b84ca4f491adb%22%7D; sajssdk_2015_cross_new_user=1");
    post.addHeader("Content_Type","application/json, text/plain, */*");
    String paramJson="{\n" +
            "  \"req_data\": {\n" +
            "    \"text\": \"买枪神\\n\",\n" +
            "    \"image_ids\": []\n" +
            "  }\n" +
            "}";
    StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
    post.setEntity(stringEntity);
    CloseableHttpResponse execute = httpClient.execute(post);
    if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
        String res = EntityUtils.toString(execute.getEntity());
        System.out.println(res);
    }else {
        System.out.println(execute.getStatusLine().getStatusCode());
    }

}

}
