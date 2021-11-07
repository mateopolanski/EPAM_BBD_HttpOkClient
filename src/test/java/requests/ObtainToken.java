package requests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import static utility.Properties.*;

public class ObtainToken {

    @Test
    public static void main(String[] args) throws Exception {


//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(
//                new AuthScope(AuthScope.ANY_REALM,AuthScope.ANY_PORT),
//                new UsernamePasswordCredentials(username, password));
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCredentialsProvider(credsProvider)
//                .build();
//        try {
//            HttpGet httpget = new HttpGet(authURL);
//
//            System.out.println("Executing request " + httpget.getRequestLine());
//            CloseableHttpResponse response = httpclient.execute(httpget);
//            try {
//                System.out.println("----------------------------------------");
//                System.out.println(response.getStatusLine());
//                System.out.println(EntityUtils.toString(response.getEntity()));
//            } finally {
//                response.close();
//            }
//        } finally {
//            httpclient.close();
//        }


//        CredentialsProvider provider = new BasicCredentialsProvider();
//        UsernamePasswordCredentials credentials
//                = new UsernamePasswordCredentials(username , password);
//        provider.setCredentials(AuthScope.ANY, credentials);
//
//        HttpClient client = HttpClientBuilder.create()
//                .setDefaultCredentialsProvider(provider)
//                .build();
//
//        HttpResponse response = client.execute(
//                new HttpGet(authURL));
//        int statusCode = response.getStatusLine()
//                .getStatusCode();
 //       assertThat(statusCode, equalTo(HttpStatus.SC_OK));

        HttpGet request = new HttpGet(authURL);

        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(username,password)
        );

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // 401 if wrong user/password
            System.out.println(response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }



    }
}
