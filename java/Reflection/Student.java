package Reflection;

import java.sql.Date;

public class Student {
    private Date date;
    private String name;
    private int age;
  
 //   private int score;
    
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
 /*   public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
   public void setAge(int age) {
        this.age = age;
    }
@Override
public String toString() {
    return "Student [name=" + name + ", age=" + age + ", score="  + ", date=" + date + "]";
}
    
    
    

}