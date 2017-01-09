package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;

public class AsIntStream implements IntStream {
    public ArrayList<Integer> arrLst;
    private AsIntStream() {
        this.arrLst = new ArrayList<>();
    }

    public static IntStream of(int... values) {
        AsIntStream strm = new AsIntStream();
        for (int i: values){
            strm.arrLst.add(i);
        }
        return strm;
    }

    @Override
    public Double average() {
        if (arrLst.isEmpty()){
            throw new IllegalArgumentException("Is empty.");
        }
        return (double) sum() / count();
    }

    @Override
    public Integer max() {
        if(arrLst.isEmpty()){
            throw new IllegalArgumentException("Is empty.");
        }
        int max = 0;
        for (int i: arrLst ){
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        if(arrLst.isEmpty()){
            throw new IllegalArgumentException("Is empty.");
        }
        int min = 0;
        for (int i: arrLst ){
            if (i < min){
                min = i;
            }
        }
        return min;
    }

    @Override
    public long count() {
        return arrLst.size();
    }

    @Override
    public Integer sum() {
        if(arrLst.isEmpty()){
            throw new IllegalArgumentException("Is empty.");
        }
        int sum = 0;
        for (int i: arrLst){
            sum += i;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
       AsIntStream strmfiltr = new AsIntStream();
        for (int i: arrLst) {
            if (predicate.test(i)) {
                strmfiltr.arrLst.add(i);
            }
        }
        return strmfiltr;
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int i: arrLst){
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
       AsIntStream strmmap = new AsIntStream();
        for (int i: arrLst){
            mapper.apply(i);
        }
        return strmmap;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<IntStream> arrlst = new ArrayList<>();
        for (int i: arrLst){
            arrlst.add(func.applyAsIntStream(i));
        }
        return (IntStream) arrlst;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        for (int i: arrLst){
            identity = op.apply(i, identity);
        }
        return identity;
    }

    @Override
    public int[] toArray() {
        int[] strmarr = new int[arrLst.size()] ;
        for(int i = 0; i < arrLst.size(); i++){
            strmarr[i] = arrLst.get(i);
        }
        return strmarr;
    }
}
