package utils;

/**
 * Created by Женя on 24.06.2017.
 */
public class Sleeper {

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (Exception e){

        }
    }
}
