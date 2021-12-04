import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostUserRestClient {
    public static void main(String args[]) {

        try {
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //Set the request method to POST as required from the API
            con.setRequestMethod("POST");

            // Set the Content-Type to "application/json" as required from the API
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            //The book we want to create in JSON format
            String book = "{\"name\":\"Purab K\",\"job\":\"Programmer\"}";
            os.write(book.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();

            System.out.println("Response Code :" + responseCode);

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Created user successfully.");
            } else {
                System.out.println("Created user failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
