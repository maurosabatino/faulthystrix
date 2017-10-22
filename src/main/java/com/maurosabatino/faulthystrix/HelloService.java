package com.maurosabatino.faulthystrix;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList(String param) throws Exception {
        if(param.equals("pippo"))
            return "good hello";
        else throw new Exception("bad param");
    }

    public String reliable(String param) {
        return "fault service, bad param";
    }
}
