package tests;

import model.CreateBooking;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class CreateBookingTest {

    private CreateBooking createBooking = new CreateBooking();

    @Test
    void testBooking() throws IOException {

        CreateBooking.postBooking();

    }
}