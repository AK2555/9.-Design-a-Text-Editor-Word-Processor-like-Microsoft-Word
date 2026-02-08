package org.example;

public class Solution implements Q09TextEditorInterface{
    private Helper09 helper;
    MsWord msWord;
    public Solution(){
        msWord=new MsWord();
        msWord.addPage("1");
    }
    public void init(Helper09 helper) {
        this.helper=helper;
    }

    public void addCharacter(int row, int column, char ch,
                             String fontName, int fontSize, boolean isBold, boolean isItalic) {
      msWord.addCharacter("1",row,column,ch,fontName,fontSize,isBold,isItalic);
    }

    // return "k-tahoma-22-b-i" or "j-Arial Black-8-i"
    public String getStyle(int row, int col) {
        return msWord.getStyle("1",row,col);
    }

    // e.g."what are you waiting for"
    public String readLine(int row) {
        return msWord.readLine("1",row);
    }

    // returns true if a character is deleted or false if no character
    public boolean deleteCharacter(int row, int col) {
        return msWord.deleteCharacter("1",row,col);
    }
}


 interface Q09TextEditorInterface{
 void init(Helper09 helper);
 void addCharacter(int row, int column, char ch, String fontName,
 int fontSize, boolean isBold, boolean isItalic);
 String getStyle(int row, int col);
 String readLine(int row);
 boolean deleteCharacter(int row, int col);
 }
 class Helper09{
 void print(String s){System.out.print(s);} void println(String s){print(s+"\n");}
 }
