package Ch02_List;

import java.util.Arrays;

public class RunMyArrayList {
    public static void main(String[] args) {
        MyList<String> my = new MyLinkedList<>();

        System.out.println("데이터 추가");
        my.add("김씨");
        my.add("이씨");
        my.add("정씨");
        my.add("박씨");
        System.out.println(my);

        System.out.println("\n데이터 삭제");
        my.delete("이씨");
        System.out.println(my);

        System.out.println("\n데이터 클리어");
        my.clear();
        System.out.println(my);

        System.out.println("\n데이터 51개 추가");
        for (int i = 1; i <= 51; i++) {
            my.add(String.valueOf(i));
        }
        System.out.println(my);

        System.out.println("\n데이터 삽입");
        my.insert(9, "짭10");
        System.out.println(my);

        System.out.println("\n데이터 조회 인덱스");
        System.out.println(my.get(9));

        System.out.println("\n데이터 인덱스 찾기");
        System.out.println(my.indexOf("짭10"));

        System.out.println("\n데이터 포함 여부");
        System.out.println(my.contains("짭10"));
        System.out.println(my.contains("짭11"));
    }
}
