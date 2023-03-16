package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Algorithms {

    public static ArrayList<Integer> readFileArr(File f) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        for(String s : Files.readAllLines(f.toPath())) {
            arr.add(Integer.parseInt(s));
        }
        return arr;
    }

    public static ArrayList<String> readFileArrString(File f) throws IOException {
        return new ArrayList<>(Files.readAllLines(f.toPath()));
    }

    public static String readFileString(File f) throws IOException {
        StringBuilder bobTheBuilder = new StringBuilder();
        for(String s : Files.readAllLines(f.toPath())) {
            //arr.add(Integer.parseInt(s));
            bobTheBuilder.append(s);
        }
        return bobTheBuilder.toString();
    }

    public static void appendFile(File destination, String content) throws IOException {
        if(!destination.exists())
            destination.createNewFile();
        String finalContent = readFileString(destination) + "\n" + content;
        FileWriter writer = new FileWriter(destination);
        writer.write(finalContent);
        writer.close();
    }

    /**
     *
     * @param arr
     * @return arraylist: index 0 is the highest number, and index 1 is index of the highest number
     */
    public static ArrayList<Integer> getHighestNumAndItsIndexInArr(ArrayList<Integer> arr) {
        int temp = 0;
        int tempIndex = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) > temp) {
                temp = arr.get(i);
                tempIndex = i;
            }
        }

        return new ArrayList<>(Arrays.asList(temp, tempIndex));
    }

    public static ArrayList<Integer> sumArraysWithTheSameLength(ArrayList<Integer> arr, ArrayList<Integer> arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++)
            result.add(arr.get(i) + arr2.get(i));
        return result;
    }

    public static void bubbleSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.size()-i-1; j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        boolean flag = true;
        if(n == 1)
            return false;

        for(int i = 2; i < n; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String decimalToHex(int decimal) {
        final ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('A','B','C','D','E','F'));
        final ArrayList<Integer> powersOf16 = new ArrayList<>(Arrays.asList(65536,4096,256,16,1));
        ArrayList<Integer> counters = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        int temp = decimal;
        for(int i = 0; i < powersOf16.size(); i++) {
            while(temp >= powersOf16.get(i)) {
                temp -= powersOf16.get(i);
                counters.set(i, counters.get(i) + 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Integer counter : counters) {
            if (counter > 9) {
                result.append(alphabet.get(counter - 10));
            } else if (counter > 0) {
                result.append(counter);
            } else { //if counter == 0
                boolean keepThisZero = false;
                for(int i = 0; i < result.length(); i++) {
                    if(result.charAt(i) != 0)
                        keepThisZero = true;
                }
                if(keepThisZero)
                    result.append(counter);
            }
        }
        return result.toString();
    }
}
