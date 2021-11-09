package model;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utility.Properties;

import java.io.IOException;

public class CreateBooking {


    public static void postBooking() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(Properties.baseURL);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            String json = "{\n" +
                    "    \"firstname\": \"Mati\",\n" +
                    "    \"lastname\": \"Test\",\n" +
                    "    \"totalprice\": 111,\n" +
                    "    \"depositpaid\": true,\n" +
                    "    \"bookingdates\": {\n" +
                    "        \"checkin\": \"2022-01-01\",\n" +
                    "        \"checkout\": \"2022-02-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\": \"Breakfast\"\n" +
                    "}";

            StringEntity stringEntity = new StringEntity(json);
            httpPost.setEntity(stringEntity);

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}
