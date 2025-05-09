package D3.P1244;

import java.io.*;
import java.util.*;

public class Solution {
    static int N;       // 케이스의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] input = st.nextToken().split("");
            int changeCount = Integer.parseInt(st.nextToken());

            PriorityQueue<NumberAndIndex> pq = new PriorityQueue<NumberAndIndex>((a, b)
                    -> a.number != b.number ? b.number - a.number : b.index - a.index);
            List<NumberAndIndex> list = new ArrayList<NumberAndIndex>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int j=0; j<input.length; j++){
                int number = Integer.parseInt(input[j]);
                pq.add(new NumberAndIndex(number, j));
                list.add(new NumberAndIndex(number, j));
                insertNumber(hm, number);
            }
            System.out.println(hm);
            for(int j=0; j<input.length; j++){
                System.out.println(pq.poll());
            }
        }
    }

    public static void change(List<NumberAndIndex> list, int index1, int index2){
        NumberAndIndex temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static void insertNumber(HashMap<Integer, Integer> hm, int number){
        if(hm.containsKey(number)){
            hm.replace(number, hm.get(number) + 1);
        } else {
            hm.put(number, 1);
        }
    }

    static class NumberAndIndex {
        int number;
        int index;
        public NumberAndIndex(int number, int index) {
            this.number = number;
            this.index = index;
        }
        @Override
        public String toString() {
            return "[" + number + "," + index + "]";
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NumberAndIndex NAI = (NumberAndIndex) o;
            return number == NAI.number && index == NAI.index;
        }
        @Override
        public int hashCode() {
            return 0;
        }
    }
}
