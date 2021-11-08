package requests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utility.Properties.baseURL;

public class ReturnAllBookings {

    public static void main(String...args) throws IOException {

        getAllBookings();

    }
    @Test
    public static void getAllBookings() throws IOException{
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            //HTTP GET method
            HttpGet httpget = new HttpGet(baseURL);
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler< String > responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
             }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
//
//            HttpClient client = HttpClientBuilder.create().build();
//            HttpResponse response = client.execute(new HttpGet(baseURL));
//            int statusCode = response.getStatusLine().getStatusCode();
//            assertThat(statusCode, equalTo(HttpStatus.SC_OK));
        }
    }
}

