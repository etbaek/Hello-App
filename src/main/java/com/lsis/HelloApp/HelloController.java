package com.lsis.HelloApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/hello")
public class HelloController {
    private String helloMsg;
    private HelloService helloService;

    public HelloController(@Value("${welcome.message}") String helloMsg,
                           HelloService helloService) {
        this.helloMsg = helloMsg;
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String Hello() {
        return helloMsg;
    }

    @IncrementCounter
    @PostMapping("/hello")
    public void addHello(@RequestBody Hello hello){
        helloService.add(hello);
    }

    @IncrementCounter
    @GetMapping("/hello")
    public List<Hello> getHelloAll(){
        return (List<Hello>) helloService.getAll();
    }

    @IncrementCounter
    @GetMapping("/hello/{id}")
    public Hello getHello(@PathVariable long id){
        return helloService.get(id);
    }

    @IncrementCounter
    @PutMapping("/hello")
    public void updateHello(@RequestBody Hello hello){
        helloService.update(hello);
    }

    @IncrementCounter
    @DeleteMapping("/hello")
    public void deleteHello(@RequestBody Hello hello){
        helloService.delete(hello);
    }

    @IncrementCounter
    @DeleteMapping("/hello/{id}")
    public void deleteHello(@PathVariable long id){
        helloService.deleteById(id);
    }
}
