package com.silvinovieira.dscommerce.tests;

import java.util.Arrays;

public class teste {
        static String toCamelCase(String s){
            String[] list = s.split("_|-");
            for (int i = 1; i<list.length;i++){
                Character.toUpperCase(list[i].charAt(0));
            }
            Arrays.stream(list).map(x -> Character.toUpperCase(x.charAt(0)));
            return String.join("", list);
        }
}
