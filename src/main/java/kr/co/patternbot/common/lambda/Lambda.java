package kr.co.patternbot.common.lambda;

import java.io.File;
import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        //System.out.println(integer("900"));
        /**
         System.out.println(string(new Apple.Builder().origin("영동").color("RED").price(3000).build()));
         System.out.println(
         string(
         Arrays.asList(
         new Apple.Builder().origin("영동").color("RED").price(1000).build(),
         new Apple.Builder().origin("영동").color("BLUE").price(2000).build(),
         new Apple.Builder().origin("풍기").color("BLUE").price(3000).build()
         ))
         );*/
        //System.out.println(array(10).length);
        System.out.println(random(1,6));
    }
    public static int integer(String s){
        //Integer i = Integer.parseInt("900")
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(s);
    }
    public static long longParse(String s){
        Function<String, Long> f = Long::parseLong;
        return f.apply(s);
    }
    public static float floatParse(String s){
        Function<String, Float> f = Float::parseFloat;
        return f.apply(s);
    }
    public static String string(Object o){
        // String s = String.valueOf(Object);
        Function<Object, String> f = String::valueOf;
        return f.apply(o);
    }
    public static boolean equals(String s1, String s2){
        BiPredicate<String, String> f = String::equals;
        return f.test(s1, s2);
    }
    //int[] arr = new int[8]
    //= int[]::new
    public static int[] array(int a){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(a);
    }
    //int[] arr = new int[8]
    //= int[]::new
    //int min, int max = 최대값 최소값
    //int random(int min, int max) 함수임
    //BiFunction<Integer, Integer, Integer> f = () -> {return(int)(Math.random()*max)+min;}이건데 리턴 생략 가능
    //파라미터가 왜 달라야 하는지?
    public static int random(int min, int max){
        BiFunction<Integer, Integer, Integer> f = (min1, max1) -> (int)(Math.random()*max1)+min1;
        return f.apply(min, max);
    }
    //choi라는 이름 타입 int ret타입 있음
    String choi(int i){
        Function<Integer, String> f = String::valueOf;
        return f.apply(i);
    }
    //makefile 메서드 이름
    // File file = new File();
    //File 타입임.
    public static File makefile(String a){
        Function<String, File> f = File::new;
        return f.apply(a);
    }
    public static String date(){
        Supplier<String> f = () -> string(LocalDate.now());
        return f.get();
    }
}
