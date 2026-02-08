package org.example;

import org.example.models.Block;
import org.example.models.Page;

import java.util.*;

public class MsWord {
    private Map<String,Page> pages;

    public MsWord(){
        this.pages=new HashMap<>();
    }

    public void addPage(String pageId){
        pages.put(pageId,new Page(UUID.randomUUID().toString()));
    }

    public void addCharacter(String pageId,int row, int col, char ch,
                             String fontName, int fontSize, boolean isBold, boolean isItalic){
        if(!pages.containsKey(pageId)){
            return;
        }
        pages.get(pageId).addCharacter(row,col,new Block(ch,fontName,fontSize,isBold,isItalic));
    }

    public String getStyle(String pageId,int row,int col){
        if(!pages.containsKey(pageId)){
            return "";
        }
      return pages.get(pageId).getStyle(row,col);
    }

    public String readLine(String pageId,int row){
        if(!pages.containsKey(pageId)){
            return "";
        }
       return pages.get(pageId).readLine(row);
    }

    public boolean deleteCharacter(String pageId,int row,int col){
        if(!pages.containsKey(pageId)){
            return false;
        }
        return pages.get(pageId).deleteCharacter(row,col);
    }

}
