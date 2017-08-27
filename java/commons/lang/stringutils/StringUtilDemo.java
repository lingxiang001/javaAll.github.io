package commons.lang.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StringUtilDemo {
    public static void main(String[] args){
        String str1=StringUtils.right("donglingxiang,", 4);
        String str2="donglingxiang.".substring(5);
        String str3=StringUtils.rightPad("dong", 5,"lin");
        
        String str4=StringUtils.rotate("ling",5);
        String str5=StringUtils.substring("dong", -1);
        String[] str6=StringUtils.splitByCharacterTypeCamelCase("DooNnG");
        
        char[] ch={'d','o','n'};
        String str7=new String(ch,0,1);
        String[] str8=StringUtils.splitByWholeSeparatorPreserveAllTokens(" D on g", " ", 4);
        String str10=StringUtils.strip("x11y ","y");
        String str11=StringUtils.stripAccents("  do ng ");
        String str12=StringUtils.truncate("dong", 2, 1);
        String str13=StringUtils.uncapitalize("Dong");
        String str14=StringUtils.unwrap("AAAA","AA");
        String str15=StringUtils.wrap("AABA", "AAB");
        String str16 = StringUtils.wrapIfMissing(" ", "A");
        for(String str:str8){
            System.out.println(str);
        }
        
        System.out.println(str16);
    }

}
