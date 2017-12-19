package com.linjianfu.chapter11;

import java.util.*;

class MovieBuilder {
    private static ArrayList<String> movies, movie = new ArrayList<String>(Arrays.asList(("ZhuXian MingChao").split(" ")));
    private int id = 0;

    //Demonstrating methods of adding elements:
    {
        movie.add("Snow White");
        Collections.addAll(movie, "Star Wars", "XiaoMi");
        String[] strings1 = {"One"}, strings2 = {"Two"};
        Collections.addAll(movie, strings1);
//        movie.addAll(strings2);//Error
        movie.addAll(Arrays.asList(strings2));
        movies = movie;
        System.out.println("movies:" + movies);
        System.out.println(movies.size());

    }

    public String next2() {
        switch (id++) {
            default:
            case 0:
                return "ZhuXian";
            case 1:
                return "MingChao";
            case 2:
                return "Snow White";
            case 3:
                return "Star Wars";
            case 4:
                return "XiaoMi";
            case 5:
                return "One";
            case 6:
                id = 0;
                return "Two";


        }
    }

    public String next() {
        if (id == movies.size())
            id = 0;
        return movie.get(id++);

    }

    public void fillS(String[] s) {
        for (int i = 0; i < s.length; i++)
            s[i] = next2();

    }

    public Collection fill(Collection<String> collection, int n) {
        id = 0;
        for (int i = 0; i < n; i++)
            collection.add(next());
        //or:
//            collection.add(next2());
        return collection;
    }
}

public class Eleven4 {
    public static void main(String[] args) {
        MovieBuilder m = new MovieBuilder();
        int n = 10;
        String[] s = new String[n];
        m.fillS(s);
        for (String ss : s)
            System.out.print(ss + ", ");
        System.out.println();
        System.out.println(m.fill(new ArrayList<>(), n));
        System.out.println(m.fill(new LinkedList<>(), n));
        System.out.println(m.fill(new HashSet<>(), n));
        System.out.println(m.fill(new LinkedHashSet<>(), n));
        System.out.println(m.fill(new TreeSet<>(), n));

    }
}
