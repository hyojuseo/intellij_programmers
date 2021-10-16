import java.util.*;

public class test {
    public static int[] solution(String[] genres, int[] plays) {
        int i=0, j=0;
        int max=0, first=-1, second=-1;
        //가장 많은 재생수인 장르구하기
        ArrayList<String> genre = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }

        for(String s : map.keySet()) genre.add(s);
        Collections.sort(genre, ((o1, o2) -> map.get(o2)-map.get(o1))); //genre에 재생수가 가장 많은순으로 장르정렬

        //같은 장르에서의 재생수가 제일 많은 1,2순 뽑기
        ArrayList<Integer> list = new ArrayList<>();
        for(i=0; i<genre.size(); i++){
            max = 0;
            first = -1;
            second = -1;

            for(j=0; j<genres.length; j++){
                if(genre.get(i).equals(genres[j]) && max<plays[j]) {
                    max = plays[j];
                    first = j;
                }
            }

            max = 0;
            for(j=0; j<plays.length; j++){
                if(genre.get(i).equals(genres[j]) && max<plays[j] && j != first) {
                    max = plays[j];
                    second = j;
                 }
            }
            list.add(first);
            if(second != -1) list.add(second);  //장르가 1개, 재생수가 1개일경우. second는 나오면 안됨
        }
        //고유번호 answer에 넣는다
        int[] answer = new int[list.size()];
        for (i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic","pop","classic"};
        int[] plays = {500,600,150};

        System.out.print("[");
        for (int i = 0; i < solution(genres, plays).length; i++) {
            System.out.print(solution(genres, plays)[i]);
            if (i != solution(genres, plays).length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }

}