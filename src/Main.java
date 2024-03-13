import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

interface Sort{
    public void excute(ArrayList<Integer> lst);
}

class Sorting {
    Sort sort ;
    Sorting(Sort sort) { // 의존성 주입 (생성자 주입)
        this.sort = sort;
    }
    public void excute(ArrayList<Integer> lst){
        sort.excute(lst);
    }
}

class BubbleSort implements Sort{
    @Override
    public void excute(ArrayList<Integer> lst) {
        for(int cycle = 0; cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
}

class SelectionSort implements Sort{
    @Override
    public void excute(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(3,3,3,2,1,1,2,3,2,1,2,3,1,2,3,2,1,5,5,2,1,7));

        // insert 기능
        System.out.println("추가할 숫자를 입력하세요");
        lst.add(sc.nextInt());

        // selection 기능
        Sorting s;
        System.out.println("원하는 Sort 종류를 입력해 주세요.\n" +
                "1 : Bubble Sort\n" +
                "2 : Selection Sort");
        int sortType = sc.nextInt();
        if(sortType == 1) {
            BubbleSort bs = new BubbleSort();
            s = new Sorting(bs);
        } else if (sortType == 2) {
            SelectionSort ss = new SelectionSort();
            s = new Sorting(ss);
        } else {
            System.out.println("1 또는 2를 입력해 주세요");
            return;
        }

        // run 기능
        s.excute(lst);

        // show 기능
        System.out.println(lst);
    }
}
