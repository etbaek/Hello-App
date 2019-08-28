package com.lsis.HelloApp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelloService {
    private HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public void add(Hello hello){
        helloRepository.save(hello);
    }

    public List<Hello> getAll(){
        return (List<Hello>) helloRepository.findAll();
    }

    public Hello get(long id){
        Optional<Hello> hello = helloRepository.findById(id);
        return hello.get();
    }

    public void update(Hello hello){
        Hello helloEntity = helloRepository.findById(hello.getId()).get();
        if(hello.getCountry()!=null) helloEntity.setCountry(hello.getCountry());
        if(hello.getHelloMessage()!=null) helloEntity.setHelloMessage(hello.getHelloMessage());
        if(hello.getLanguage()!=null) helloEntity.setLanguage(hello.getLanguage());

        helloRepository.save(helloEntity);
    }

    public void delete(Hello hello){
        helloRepository.delete(hello);
    }

    public void deleteById(long id){
        helloRepository.deleteById(id);
    }
}
