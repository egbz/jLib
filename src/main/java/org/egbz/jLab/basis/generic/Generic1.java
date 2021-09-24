package org.egbz.jLab.basis.generic;

/**
 * @author egbz
 * @date 2021/9/24
 */
public class Generic1 {

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 123);
        int n = add(p);
        System.out.println(n);
    }

    static class Pair<T> {
        private T first;
        private T last;

        public Pair(T first, T last) {
            this.first = first;
            this.last = last;
        }
        public T getFirst() {
            return first;
        }

        public T getLast() {
            return last;
        }
    }
}
