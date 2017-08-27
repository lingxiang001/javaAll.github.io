package random;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeMap;

import sql.jdbc_utils.JDBCFacadeImpl;

public class FindWord {
    public static void findWord(){
        for(int i=97;i<123;i++){
            char c=(char) i;
            System.out.println(c);
            String sql="SELECT word,num FROM random WHERE word like '"+c+"%' ORDER BY num LIMIT 10";
            ResultSet rs= JDBCFacadeImpl.me.executeQueries(sql);
            TreeMap<String ,Integer> map=new TreeMap<String,Integer>();
            try {
                while(rs.next()){
                    map.put(rs.getString("word"),rs.getInt("num"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
      
    }
    public static void main(String[] args) {
       findWord();

    }

}
