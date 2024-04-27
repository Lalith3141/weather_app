package Weather.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ServiceNumbers {

    public List a = new ArrayList<>();

    @Async("taskExecutor")
    public void addNumbers(){
        a = IntStream.range(1,10).boxed().collect(Collectors.toList());
    }

    @Async(("taskExecutor"))
    public void addAlpha(){
        a = IntStream.rangeClosed('a','j').mapToObj(c -> (char) c).collect(Collectors.toList());
    }


    
}
