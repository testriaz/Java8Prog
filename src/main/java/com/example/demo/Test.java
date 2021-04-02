package com.example.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
	
	private static final Logger logger = LogManager.getLogger(Test.class);

	static int getNumber() {
		return 5;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        logger.debug("Hello from Log4j 2");

        // in old days, we need to check the log level to increase performance
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", getNumber());
        }*/

        // with Java 8, we can do this, no need to check the log level
        logger.debug("{}", () -> getNumber());
        
        //Range
        IntStream stream = IntStream.range(5, 10); 
        stream.forEach( System.out::print );  //5,6,7,8,9
        System.out.println();
        //Closed Range
        
        IntStream closedRangeStream = IntStream.rangeClosed(5, 10); 
        closedRangeStream.forEach( System.out::print );   //5,6,7,8,9,10
        
        System.out.println();
        
        IntStream stream1 = IntStream.generate(() 
                -> { return (int)(Math.random() * 10000); }); 
     
        stream1.limit(3).forEach(System.out::println); 
        
        ConcurrentHashMap<Integer,String> conHash = new ConcurrentHashMap<Integer,String> ();
        
        conHash.put(100, "Hello"); 
        conHash.put(101, "Geeks"); 
        conHash.put(102, "Geeks"); 
        
        ConcurrentHashMap.KeySetView<Integer,String> test = conHash.keySet();

        
        for(Integer in : test) {
        	System.out.println(in );
        }
        
        List<String> intValues = new ArrayList<String>();
        intValues.add("1");
        intValues.add("2");
        intValues.add("3");
        
        
        List<Integer> testValues = intValues.stream().map(str ->{
      
        	System.out.println("===============>" );
        	return Integer.parseInt(str); 
        
        }).collect(Collectors.toList());

        System.out.println("testValues ===============>"+ testValues);
        
        List<Integer> testValues1 = 
        		intValues.stream().map(str ->Integer.parseInt(str)).collect(Collectors.toList());

        System.out.println("testValues1 ===============>"+ testValues1);
        
        // String Join
        List mylist = Arrays.asList("London", "Paris", "NewYork");
        String joined = String.join("||", mylist);
        System.out.println("joined ===============>"+ joined);
        
        
        System.out.println("tes,test".indexOf("d"));
        
        
        
	}
	

}
