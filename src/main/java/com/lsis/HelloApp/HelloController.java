package com.lsis.HelloApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {
    private String helloMsg;
    private HelloService helloService;

    public HelloController(@Value("${welcome.message}") String helloMsgsg, HelloService helloService) {
        this.helloMsg = helloMsg;
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String Hello() {
        return helloMsg;
    }

    @PostMapping("/hello")
    public void addHello(@RequestBody Hello hello){
        helloService.add(hello);
    }

    @GetMapping("/hello")
    public List<Hello> getHelloAll(){
        return (List<Hello>) helloService.getAll();
    }

    @GetMapping("/hello/{id}")
    public Hello getHello(@PathVariable long id){
        return helloService.get(id);
    }

    @PutMapping("/hello")
    public void updateHello(@RequestBody Hello hello){
        helloService.update(hello);
    }

    @DeleteMapping("/hello")
    public void deleteHello(@RequestBody Hello hello){
        helloService.delete(hello);
    }

    @DeleteMapping("/hello/{id}")
    public void deleteHello(@PathVariable long id){
        helloService.deleteById(id);
    }

}
