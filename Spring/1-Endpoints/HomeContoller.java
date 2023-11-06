package web.libaries.Endpoints;

import org.springframework.web.bind.annotation.*;

@RestController          // This annotation marks the class as a REST controller.
@RequestMapping("/v1")   // This specifies the base path for all endpoints in this controller.
public class HomeContoller {

    /*
    http://127.0.0.1:8080/v1/hello
    Result: hello to you
     */
    @GetMapping("/hello")
    public String getTextHello() {
        return "hello to you";
    }

    /*
    Older Spring versions used this syntax with "RequestMapping"

    http://127.0.0.1:8080/v1/info/jonas
    Result: hello jonas

    @RequestMapping(value = "/info/{name}", method = RequestMethod.GET)
    public String getInfo(@PathVariable String name) {
        return "Hello " + name;
    }
     */

    /*
    Capture path variables in endpoint
    http://127.0.0.1:8080/v1/info/jonas
    Result: hello jonas
     */
    @GetMapping("/info/{name}")  // This annotation handles GET requests to the specified endpoint.
    // This method takes a 'name' path variable as input.
    public String getInfo(@PathVariable String name) {  
        if (name.equals("Jonas")) {
            return "Hello " + name;
        } else {
            return "Bye Bye " + name;
        }
    }

    /*
    Query params to endpoint
    http://127.0.0.1:8080/v1/hello/to?name=Jonas
    Result: Hello Jonas

    If no parameter were given then it will be default "World"
    http://127.0.0.1:8080/v1/hello/to
    Result: Hello World
     */
    @GetMapping("/hello/to")
    // Create a response message using the provided "name" parameter or the default value "World"
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
