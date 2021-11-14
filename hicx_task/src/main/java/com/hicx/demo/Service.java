package com.hicx.demo;


import java.util.HashMap;

public class Service {

    public Service() {
    }

    public void findStatictics(String data)
    {
        totalWords(data);
        totalDots(data);
        countSpecialCharacter(data);
        totalWhiteSpaces(data);
    }

    public void totalWords(String data)
    {
        HashMap<String,Integer> map = new HashMap<>();
        String[] words = data.split("\\s+");
        System.out.println(":: Total Number of Words are : " +words.length);
        Integer mostOccured = Integer.MIN_VALUE;
        String commonName="";
        for(var i =0 ; i < words.length ; i++) // O(n)
        {
            map.put(words[i],map.getOrDefault(words[i],1));

            if(map.get(words[i]) > mostOccured)
            {
                commonName = words[i];
                mostOccured = map.get(words[i]);
            }
        }
        System.out.println(":: Most Used Word in the File : " +commonName);
    }

    public void countSpecialCharacter(String data)
    {
        int countSpecial = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i+1).matches("[^A-Za-z0-9]")) {
                countSpecial++;
            }
        }
        System.out.println(":: Total Number of Special Characters are : " + (data.length()-countSpecial));

    }

    public void totalWhiteSpaces(String data)
    {
        System.out.println(":: Total Number of White Spaces are : "+ data.replaceAll(" ", "").length());
    }

    public void totalDots(String data)
    {
        System.out.println(":: Total Number of Dots are : "+ (data.length() - data.replace(".", "").length()));
    }


}
