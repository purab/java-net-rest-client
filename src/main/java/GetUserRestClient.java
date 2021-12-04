import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetUserRestClient {

    public static void main(String[] args) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String retVal = null;
        try {
            URL resetEndpoint = new URL("https://reqres.in/api/users?page=2");
            connection = (HttpURLConnection) resetEndpoint.openConnection();
            //Set request method to GET as required from the API
            connection.setRequestMethod("GET");

            // Read the response
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonSb.append(line);
            }
            retVal = jsonSb.toString();

            // print out the json response
            System.out.println(retVal);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
