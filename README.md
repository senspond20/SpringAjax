# AJAX

# HttpServletRequest

## Case 0
+ RestController

```java
@PostMapping("/api/test0")
public Object method0(HttpServletRequest request){
    
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    System.out.println(name);
    System.out.println(email);
    // return Arrays.asList(name,email);
    Map<String,Object> resultMap = new HashMap<String,Object>();
    resultMap.put("name", name);
    resultMap.put("email", email);
    return resultMap;
}
```
+ view
```html
<button id ="btn">클릭</button>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
```

```js
var obj ={
    name : "안녕",
    email : "gege@gmail.com"
}
$('#btn').click(function(){
    method1();
});

function method0(){
    $.ajax({
        url : "/api/test0",
        method : "post",
        data : obj,
    }).done(function(data){
        console.log(data);
    }).fail(function(error){
        console.log(error);
    })
}
```

```xml
<!-- https://mvnrepository.com/artifact/org.json/json -->
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20180813</version>
</dependency>
```

# Dto

+ Dto
```java
@Data
public class TestDto {
    private String name;
    private String email;
}
```

## Case 1 
+ RestController

```java
//**Json Input 으로는 받을 수가 없다.**
@PostMapping("/api/test1")
public Object method1(TestDto testDto){

    System.out.println(testDto.getName());
    System.out.println(testDto.getEmail());
    return testDto;
}
```


+ view
```html
<button id ="btn">클릭</button>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
```

```js
var obj ={
    name : "안녕",
    email : "gege@gmail.com"
}
$('#btn').click(function(){
    method1();
});

function method1(){
    $.ajax({
        url : "/api/test1",
        method : "post",
        data : obj,
    }).done(function(data){
        console.log(data);
    }).fail(function(error){
        console.log(error);
    })
}
```



## Case 2

+ RestController
```java
/* Json Input 으로도 받을 수가 있다. 
   그러나 ajax 사용시 Case1 방식으로 사용하면 오류가 난다.*/
@PostMapping("/api/test2")
public Object method1(@RequestBody TestDto testDto){

    System.out.println(testDto.getName());
    System.out.println(testDto.getEmail());
    return testDto;
}
```

+ view

```html
<button id ="btn">클릭</button>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
```
```js
var obj ={
    name : "안녕",
    email : "gege@gmail.com"
}
$('#btn').click(function(){
    method2();
});

function method2(){
    $.ajax({
        url : "/api/test2",
        method : "post",
        data : JSON.stringify(obj), // 직렬화
        contentType : "application/json"
    }).done(function(data){
        console.log(data);
    }).fail(function(error){
        console.log(error);
    })
}
```

# Map

## Case3
+ Case2번과 동일하게 Map으로 받는 방법

```java
@PostMapping("/api/test3")
public Object method1(@RequestBody Map<String,Object> map){

    System.out.println(map.get("name"));
    System.out.println(map.get("email"));
    return map;
}
```

## Case4
+ Case2번과 동일하게 CommandMap 을 사용하는 방법

