package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private String id;
    private List<List<Block>> blocks;

    public Page(String id){
        this.id=id;
        blocks=new ArrayList<>();
    }


    public void addCharacter(int row,int col,Block block){
        if(row>= blocks.size()){
            int n=row-blocks.size()+1;
            for(int i=0;i<n;i++){
                blocks.add(new ArrayList<>());
            }
        }
        if(col>=blocks.get(row).size()){

           // helper.print(blocks.size()+" "+row+" "+col+"||||");
            blocks.get(row).add(block);
            return;
        }
        List<Block> list=blocks.get(row);
        int ind=col;
        Block prevVal=list.get(ind);
        list.set(ind,block);
        for(int i=ind+1;i<list.size();i++){
            Block tmp=list.get(i);
            list.set(i,prevVal);
            prevVal=tmp;
        }
        list.add(prevVal);
    }

    public String getStyle(int row,int col){
        if(row>=blocks.size() || col>=blocks.get(row).size()){
            return "";
        }
        if(blocks.get(row).get(col)==null){
            return "";
        }
        Block block=blocks.get(row).get(col);
        //g-Cambria-17-b-i
        String res=block.getCharacter()+"-"+block.getFontName()+"-"+block.getFontSize();
        if(block.isBold()){
            res+="-b";
        }
        if(block.isItalic()){
            res+="-i";
        }
        return res;
    }

    public String readLine(int row){
        if(row>=blocks.size()){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        List<Block> list=blocks.get(row);
        for(int i=0;i<list.size();i++){
            char ch=list.get(i).getCharacter();
            sb.append(ch);
        }
        return sb.toString();
    }

    public boolean deleteCharacter(int row,int col){
        if(row>=blocks.size() || col>=blocks.get(row).size()){
            return false;
        }
        List<Block> list=blocks.get(row);
        for(int i=col+1;i<list.size();i++){
            list.set(i-1,list.get(i));
        }
        list.remove(list.size()-1);
        return true;
    }

}
