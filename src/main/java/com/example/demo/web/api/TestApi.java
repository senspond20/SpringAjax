package com.example.demo.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.web.domain.TestDto;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    

    @PostMapping("/api/test0")
    public Object method0(HttpServletRequest request){
        System.out.println("==== test0 ====");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        System.out.println(name);
        System.out.println(email);
        // return Arrays.asList(name,email);
        // jackson data binding 에 의해서 자동 JSON output 
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("name", name);
        resultMap.put("email", email);
        return resultMap;
    }

    @PostMapping("/api/test0_J1")
    public Object method0_J1(JSONObject json){
       System.out.println("==== test0_J1 ====");
        // JSONParser parser = new JSONParser(input);
       System.out.println(json);
        return json;
    }

    @PostMapping("/api/test0_J2")
    public Object method0_J2(HttpServletRequest request){
        System.out.println("==== test0_J2 ====");
        String json = request.getParameter("jsonBody");

        System.out.println(json);

        return null;
    }

    /*
         var obj ={
            name : "안녕",
            email : "gege@gmail.com"
        }
    */


    /*
        function method1(){
        $.ajax({
            url : "/api/test2",
            method : "post",
            data : obj,
        }).done(function(data){
            console.log(data);
        }).fail(function(error){
            console.log(error);
        })
    }
    로 받을 수 있다. 그러나 json Input을 받을수가 없다.
    */
    @PostMapping("/api/test1")
    public Object method1(TestDto testDto){

        System.out.println(testDto.getName());
        System.out.println(testDto.getEmail());
        return testDto;
    }

    /*
            function method2(){
            $.ajax({
                url : "/api/test",
                method : "post",
                data : JSON.stringify(obj),
                contentType : "application/json"
            }).done(function(data){
                console.log(data);
            }).fail(function(error){
                console.log(error);
            })
        }
        로 받을 수 있다.
    */
    @PostMapping("/api/test2")
    public Object method2(@RequestBody TestDto testDto){

        System.out.println(testDto.getName());
        System.out.println(testDto.getEmail());
        return testDto;
    }



    @PostMapping("/api/test3")
    public Object method3(@RequestBody Map<String,Object> map){

        System.out.println(map.get("name"));
        System.out.println(map.get("email"));
        return map;
    }

}
