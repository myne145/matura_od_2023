package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Main.Algorithms.*;

public class Main {

    public static void zad1() throws IOException {
        ArrayList<String> content = readFileArrString(new File("szachy_przyklad.txt"));
        ArrayList<ArrayList<String>> arr = new ArrayList<>();

        ArrayList<String> temp = new ArrayList<>();
        for(String s : content) {
            if(!s.equals("")) {
                temp.add(s);
            } else {
                arr.add(new ArrayList<>(temp));
                temp.clear();
            }
        }

//        for(ArrayList<String> a : arr) {
//            System.out.println();
//            for (String s : a)
//                System.out.println(s);
//        }

        boolean isEmptyColumn;
        ArrayList<Integer> emptyIndexes = new ArrayList<>();
        for(ArrayList<String> a : arr) {
            for(int i = 0; i < a.size(); i++) {

                if(String.valueOf(a.get(i).charAt(i)).equals(".") && i == 0)
                    emptyIndexes.add(i);

                if(!String.valueOf(a.get(i).charAt(i)).equals(".") && i != 0)
                    emptyIndexes.remove((Integer) i);
                System.out.println(emptyIndexes);
            }

        }



    }

    public static void main(String[] args) throws IOException {
	    zad1();
    }
}
