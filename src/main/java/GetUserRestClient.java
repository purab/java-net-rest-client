import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetUserRestClient {

    public static void main(String[] args) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String json = null;
        try {
            URL resetEndpoint = new URL("https://reqres.in/api/users?page=2");
            connection = (HttpURLConnection) resetEndpoint.openConnection();
            // Set request method to GET as required from the API
            connection.setRequestMethod("GET");

            // Read the response
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonSb.append(line);
            }
            json = jsonSb.toString();

            // Converts JSON string to Java object
            ObjectMapper mapper = new ObjectMapper();
            // Converts to an array of Book
            User[] users = mapper.readValue(json, User[].class);
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
