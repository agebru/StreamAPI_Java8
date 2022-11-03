package demo.app;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {

        int[] data={4,5,2,6,15,20};
        int target=4;
        int j=0;
        while(  j<data.length && data[j]!=target  ){
          j++;
        }

        System.out.println("J: "+j);
       List<Integer> evens= Arrays.stream(data)
                .filter(x->x%2==0)
               .mapToObj(Integer::new)   //intV->new Integer(intV)
                .collect(Collectors.toList());
        System.out.println("Evens: "+evens);


        Stream<String> stringStream = 
        		Arrays.stream(data)
                      .filter(x -> x % 2 != 0)
                      .mapToObj(String::valueOf);


        List<String> oddsAsString= Arrays.stream(data)
                .filter(x->x%2!=0)
                .mapToObj(String::valueOf)   //i->String.valueOf(i)
                .collect(Collectors.toList());

        System.out.println("Odds as String: "+oddsAsString);


        int max= Arrays.stream(data).max().getAsInt();
        System.out.println("Max: "+max);

        Random random=new Random();
        int i = random.nextInt(3);
        System.out.println("Generated: "+i);

    }
}
