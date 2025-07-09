package Collection_Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/* Bài 1. Tạo ra 2 dãy số A gồm 100.000 số nguyên dương ngẫu nhiên
có giá trị trong đoạn [0, 2000]. Sử dụng cấu trúc dữ liệu thích hợp để.
a. Tạo ra một dãy B mới từ dãy A gồm các số có giá trị khác nhau trong dãy A.
b. Đếm số lần xuất hiện của mỗi số trong dãy A; từ đó, tìm ra số có số lần xuất hiện nhiều nhất.
c. Tạo một dãy C gồm 10000 số nguyên dương có giá trị ngẫu nhiên trong đoạn từ [1000, 3000],
kiểm tra từng phần tử trong dãy C có xuất hiện trong dãy A hay không. */
public class B1 {
    public static void main(String[] args) {
        int[] A = new int[100000];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(2001); // Tạo số ngẫu nhiên trong đoạn [0, 2000]
        }
        HashSet<Integer> B = new HashSet<>();
        for (int num : A) {
            B.add(num);
        }
        System.out.println("Dãy B:");
        System.out.println(B);

        //b
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        int num = -1;
        for (HashMap.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                num = entry.getKey();
            }
        }
        System.out.println("Số xuất hiện nhiều nhất trong dãy A: " + num + " với số lần xuất hiện: " + maxCount);
        //c
        int[] C = new int[10000];
        for (int i = 0; i < C.length; i++) {
            C[i] = random.nextInt(2001) + 1000; // Tạo số ngẫu nhiên trong đoạn [1000, 3000]
        }
        for (int numC : C) {
            if (B.contains(numC)) {
                System.out.println(numC + " có xuất hiện trong dãy A.");
            } else {
                System.out.println(numC + " không có xuất hiện trong dãy A.");
            }
        }
    }
}
