package com.example.demo.web.api;

import java.util.Map;

import com.example.demo.web.domain.TestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    
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
    public Object method2(TestDto testDto){

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
    public Object method1(@RequestBody TestDto testDto){

        System.out.println(testDto.getName());
        System.out.println(testDto.getEmail());
        return testDto;
    }



    @PostMapping("/api/test3")
    public Object method1(@RequestBody Map<String,Object> map){

        System.out.println(map.get("name"));
        System.out.println(map.get("email"));
        return map;
    }

}
