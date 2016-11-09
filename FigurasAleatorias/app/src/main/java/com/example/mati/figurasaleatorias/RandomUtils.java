package com.example.mati.figurasaleatorias;

import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by mati on 9/11/16.
 */

public class RandomUtils {
    private static Random r = new Random();

    /* DEVUELVE UN ENTERO ALEATORIO **/
    public static int randomInt(int range){
        return (r.nextInt(range));
    }
    /* DEVUELVE UN INDICE ALEATORIO **/
    public static  int randomIndex(Object[] array){
        return (randomInt(array.length));
    }

    /* DEVUELVE UN ELEMENTO ALEATORIO DE UN ARRAY **/
    public static <T> T randomElement(T[] array){
        return(array[randomIndex(array)]);
    }
    /* DEVUELVE UN FLOAT ALEATORIO **/
    public static float randomFloat(int n){
        return(float)Math.random()*n;
    }
}
