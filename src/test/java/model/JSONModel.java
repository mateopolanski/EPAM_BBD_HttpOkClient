package model;

public class JSONModel {

    public static void setJSON() {
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
    }
}
