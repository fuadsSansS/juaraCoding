package com.juaracoding.CobaSiloam.collection;

import java.util.*;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on Tue 19:12
@Last Modified Tue 19:12
Version 1.0
*/
public class ArrayOfObject {


    public static void main(String[] args) {
//        int [] intArray = new int [3];
//        intArray[0] = 1;
//        intArray[1] = 2;
//        intArray[2] = 3;
//        System.out.println(intArray[0]);
//        System.out.println(intArray[1]);
//        System.out.println(intArray[2]);

        User [] userArray = new User [4];
        User varUser = new User();//135ty76
        userArray[0] = new User();
        userArray[0].setNama("Paul");
        userArray[0].setAlamat("Bogor");
        userArray[0].setEmail("poll.chihuy@gmail.com");
        userArray[0].setNoHp("628124564122");

        userArray[1] = new User();
        userArray[1].setNama("Boby");
        userArray[1].setAlamat("Jakarta");
        userArray[1].setEmail("boby.zebua@gmail.com");
        userArray[1].setNoHp("628176432131");

        userArray[2] = new User();
        userArray[2].setNama("Asrina");
        userArray[2].setAlamat("Surabaya");
        userArray[2].setEmail("asrina@ymail.com");
        userArray[2].setNoHp("62813456465");

        userArray[3] = new User("Wahyu","Bandung","wahyuwah@gmail.com","62857845121");
//        userArray[4] = new User("Wahyu","Bandung","wahyuwah@gmail.com","62857845121");

//        for (int i = 0; i < userArray.length; i++) {
//            System.out.println("============================================================");
//            System.out.println("Nama    : "+userArray[i].getNama());
//            System.out.println("Alamat  : "+userArray[i].getAlamat());
//            System.out.println("Email   : "+userArray[i].getEmail());
//            System.out.println("No HP   : "+userArray[i].getNoHp());
//        }

//        List<User> lt = new ArrayList<>();//Dynamic Binding
//        lt.add(new User());
//        lt.add(new User());
//        lt.add(new User());
//        lt.add(new User());
//
//        for (int i = 0; i < lt.size(); i++) {
//            lt.get(i).setNama(userArray[i].getNama());
//            lt.get(i).setAlamat(userArray[i].getAlamat());
//            lt.get(i).setEmail(userArray[i].getEmail());
//            lt.get(i).setNoHp(userArray[i].getNoHp());
//        }
//        lt.add(new User("Merika","Tangerang","merika@gmail.com","62857845212"));
//
//        for (int i = 0; i < lt.size(); i++) {
//            System.out.println("================================================");
//            System.out.println("Nama    : "+lt.get(i).getNama());
//            System.out.println("Alamat  : "+lt.get(i).getAlamat());
//            System.out.println("Email   : "+lt.get(i).getEmail());
//            System.out.println("No HP   : "+lt.get(i).getNoHp());
//        }
//        lt.clear();
//
//        User usr = new User();
//        usr.setNama("Paul");
//        usr.setAlamat("Bogor");
//        usr.setEmail("poll.chihuy@gmail.com");
//        usr.setNoHp("628124564122");
//        lt.add(usr);
//
//        usr = new User();
//        usr.setNama("Boby");
//        usr.setAlamat("Jakarta");
//        usr.setEmail("boby.zebua@gmail.com");
//        usr.setNoHp("628176432131");
//        lt.add(usr);
//
//        usr = new User();
//        usr.setNama("Asrina");
//        usr.setAlamat("Surabaya");
//        usr.setEmail("asrina@ymail.com");
//        usr.setNoHp("62813456465");
//        lt.add(usr);
//        System.out.println("Alamat lt : "+lt);
//
//        List<String> ls = new ArrayList<>();
//        ls.add("Merika");
//        ls.add("Tangerang");
//        ls.add("Bogor");
//
//        ls.set(2,"");

//        HashSet hashSet = new HashSet();
//        hashSet.add(1);
//        hashSet.add("2");
//        hashSet.add("3");
//        hashSet.add(4);
//        hashSet.add("4");
//        hashSet.add("4");
//        hashSet.add(new User("Wahyu","Bandung","wahyuwah@gmail.com","62857845121"));
//
//        List<User> ltUsrBaru = new ArrayList<>();
//        User usrBaru = new User();
//        ltUsrBaru.add(usrBaru);
//        ltUsrBaru.add(usrBaru);
//        ltUsrBaru.add(usrBaru);
//        System.out.println(hashSet);
//        System.out.println(ltUsrBaru);

        Map<String,String> map1 = new HashMap<>();
        map1.put("","");

        Map<String,User> map2 = new HashMap<>();
        map2.put("",new User());

        /** ini sama dengan anonymous class */
        Map<String , Object> map3 = new HashMap<>();
        map3.put("map3Key1","");
        map3.put("map3Key2",1);
        map3.put("map3Key3",new User());

        Map<Integer , Object> map4 = new HashMap<>();
        map4.put(1,"");
        map4.put(2,1);
        map4.put(3,new User());

        List<Map<String , Object>> lx = new ArrayList<>();
        /** ini sama dengan anonymous class */
        Map<String , Object> map5 = new HashMap<>();
        map5.put("nama","Paul");
        map5.put("alamat","Bogor");
        map5.put("email","poll.chihuy@gmail.com");
        map5.put("noHp","6284243316");
        map5.put("beratBadan",52);
        lx.add(map5);
        System.out.println(map5);
        System.out.println("Berat Badan adalah : "+map5.get("beratBadan"));
        for (Map.Entry<String,Object> m : map5.entrySet()) {
            System.out.println(m.getKey() + " = " + m.getValue());
        }
//java -jar demo.jar URL=https://tokopedia.com TIMEOUT=10 BROWSER=CHROME
//java -jar demo.jar CHROME 10 https://tokopedia.com

//        List<String> ltStr = new ArrayList<>();
//        List<Boolean> ltBool = new ArrayList<>();
//        System.out.println(userArray[0].getAlamat());
//        System.out.println(userArray[1].getEmail());
//        System.out.println(userArray[2].getNoHp());
    }
}
