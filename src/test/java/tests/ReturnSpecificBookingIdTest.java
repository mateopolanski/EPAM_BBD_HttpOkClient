package tests;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utility.Properties.idBookingURL;


class ReturnSpecificBookingIdTest {

//    private ReturnSpecificBookingId returnSpecificBookingId = new ReturnSpecificBookingId();

    @Test
    void testGetBookingById() throws IOException {

//        System.out.println(returnSpecificBookingId.toString());




        HttpUriRequest request = new HttpGet( idBookingURL);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assertions.assertEquals(httpResponse.getStatusLine().getStatusCode(),
                (HttpStatus.SC_OK));



    }
}