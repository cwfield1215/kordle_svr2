package org.bmchsd.cwfield.kordle_svr.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.net.URL;

import com.google.gson.JsonObject;



public class KordleClient {
    public static void main(String[] args) {
        postResults("chrfield", 1000, 3, "solved");
    }

    // public static void postResults(String user, int timeMillis, int numTries, String outcome) {
    //     try {
    //         JsonObject json = new JsonObject();
    //         json.addProperty("firstName", "Gena");
    //         json.addProperty("lastName", "Bukin");
    //         json.addProperty("email", "support@mlab.com");
            
    //         HttpRequest
    //             .post("https://safe-citadel-91138.herokuapp.com/questions")
    //             .contentType("application/json")
    //             .send(json.toString());
    //     }
    //     catch (Exception e){

    //     }
    // }

    public static void postResults(String user, int timeMillis, int numTries, String outcome) {
        try {
            URL url = new URL("http://localhost:8080/result");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\"user\": \"" + user + "\"," +
                "\"timeMillis\": \"" + timeMillis + "\"," +
                "\"numTries\": \"" + numTries + "\"," + 
                "\"outcome\": \"" + outcome + "\"}";           
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            //if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {    
                System.out.println("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
