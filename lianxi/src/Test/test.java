package Test;

import User.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {



    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("sa");
        list.add("dsa");
        Iterator it = list.iterator();
        while(it.hasNext()){
            String a = (String) it.next();
            System.out.println(a);
        }
    }



}
