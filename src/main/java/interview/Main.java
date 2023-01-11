package interview;

import DFSAndStack.LetterCombinations;

/*

 */
public class Main {
    enum Season{
        SPRING("春天","2-5"),
        SUMMER("夏天","6-9"),
        AUTUMN("秋天","9-11"),
        WINTER("冬天","12-1");
        private String name;
        private String date;
        Season(String name, String date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Season{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {

    }
    public static class A<T,K> {
        T t;
        K k;
        public <T> void print(T t) {
            System.out.println(t);
            System.out.println(k);
        }

    }

    public static <T> T print(T t){
        return t;
    }

}
