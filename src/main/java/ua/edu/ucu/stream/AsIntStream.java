package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;

public class AsIntStream implements IntStream {

    private ArrayList<Integer> arr;

    private AsIntStream(int... val) {
        arr = new ArrayList<>();
        for (int i : val) {
            arr.add(i); }
    }

    private AsIntStream(ArrayList<Integer> nlst) {
        arr = nlst; }

    public static IntStream of(int... values) {
        return new AsIntStream(values); }

    @Override
    public Double average() {
        if (arr.size() == 0){
            throw new IllegalArgumentException("It's empty.");
        }
        return (double) sum() / count();
    }

    @Override
    public Integer max() {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i); }
        }
        return max;
    }

    @Override
    public Integer min() {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i); }
        }
        return min;
    }

    @Override
    public long count() {
        return arr.size();
    }

    @Override
    public Integer sum() {
        int sum = 0;
        for (Integer i : arr) {
            sum += i; }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        ArrayList<Integer> nlst = new ArrayList<>();
        for (Integer i : arr) {
            if (predicate.test(i)) {
                nlst.add(i); }
        }
        return new AsIntStream(nlst);
    }

    @Override
    public void forEach(IntConsumer action) {
        for (Integer i : arr) {
            action.accept(i); }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        ArrayList<Integer> nArr = new ArrayList<>();
        for (Integer anArr : arr) {
            nArr.add(mapper.apply(anArr)); }
        return new AsIntStream(nArr);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<IntStream> intArr = new ArrayList<>();
        ArrayList<Integer> intAr = new ArrayList<>();
        for (Integer i : arr) {
            intArr.add(func.applyAsIntStream(i)); }
        for (IntStream k : intArr) {
            for (int i : k.toArray()) {
                intAr.add(i); }
        }
        return new AsIntStream(intAr);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        for (Integer i : arr) {
            identity = op.apply(identity, i); }
        return identity;
    }

    @Override
    public int[] toArray() {
        int toArr[] = new int[(int) count()];
        for (int i = 0; i < arr.size(); i++) {
            toArr[i] = arr.get(i); }
        return toArr;
    }

}