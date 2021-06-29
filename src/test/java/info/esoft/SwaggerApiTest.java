package info.esoft;

import static io.restassured.RestAssured.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class SwaggerApiTest {

    @Test
    public void getStoreInventoryTest(){
        Response response = get("https://petstore.swagger.io/v2/store/inventory");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postCreateWithListTest(){
        JSONObject object = new JSONObject();

        object.put("id", 0);
        object.put("username", "string");
        object.put("firstName", "string");
        object.put("lastName", "string");
        object.put("email", "string");
        object.put("password", "string");
        object.put("phone", "string");
        object.put("userStatus", 0);

        JSONArray array = new JSONArray().put(object);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(array.toString());
        Response response = request.post("https://petstore.swagger.io/v2/user/createWithList");

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void putUserTest(){
        RequestSpecification request = RestAssured.given();

        JSONObject object = new JSONObject();
        object.put("id", 0);
        object.put("username", "string");
        object.put("firstName", "string");
        object.put("lastName", "string");
        object.put("email", "string");
        object.put("password", "string");
        object.put("phone", "string");
        object.put("userStatus", 0);
        
        request.body(object.toString());
        request.header("Content-Type", "application/json");
        Response response = request.put("https://petstore.swagger.io/v2/user/234234");

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void deleteUserTest(){
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        Response response = request.delete("https://petstore.swagger.io/v2/user/string");
        Assert.assertEquals(200, response.getStatusCode());
    }

}
