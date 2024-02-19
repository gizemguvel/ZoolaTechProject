import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class CreatePetStoreUser extends PetStoreBaseUrl{

    /*
        Given
           1) url: https://petstore.swagger.io/v2/user
           2)payload:
             {
              "id": 123,
              "username": "ayse123",
              "firstName": "ayse",
              "lastName": "kaya",
              "email": "aysekaya@gmail.com",
              "password": "aysekaya123",
              "phone": "123-456-789",
              "userStatus": 0
            }

         When
           I send the POST request
         Then
           Status code is 200
         And
           Response body is like:
                              {
                                "code": 200,
                                "type": "unknown",
                                "message": "123"
                               }
     */

    @Test
    public void createUser(){
        //set the url
        spec.pathParam("first","user");

        //set the payload
        Map<String,Object> payload = new HashMap<>();
        payload.put("id",123);
        payload.put("firstName","Ayse");
        payload.put("lastName","Kaya");
        payload.put("email","aysekaya@gmail.com");
        payload.put("password","aysekaya123");
        payload.put("phone","123-456-789");
        payload.put("userStatus",0);

        //send the request and get the response
        Response response= given(spec).body(payload).post("{first}");

        //do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        //System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(200,actualData.get("code"));
        assertEquals("unknown",actualData.get("type"));
        assertEquals("123",actualData.get("message"));


    }
}
