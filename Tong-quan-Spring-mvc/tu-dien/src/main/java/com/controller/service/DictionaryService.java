package com.controller.service;

import com.controller.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryService {
    List<Dictionary> dictionaryList = new ArrayList<>();
    {
        dictionaryList.add(new Dictionary("yeu","love"));
        dictionaryList.add(new Dictionary("nho","miss"));
        dictionaryList.add(new Dictionary("sach","book"));
        dictionaryList.add(new Dictionary("luu","save"));
    }
    public String search(String a){
        for ( Dictionary dictionary: dictionaryList){
               if (dictionary.getEngLish().equals(a)){
                   return dictionary.getViet();
               }
        }
        return null;
    }
}
