package it.unibo.es3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics{

    Set<Pair<Integer,Integer>> matrix;
    Random random = new Random();
    int matrixSize;

    public LogicsImpl(int size){
        matrix=new HashSet<>();
        matrixSize=size;

        for(int i=0; i < 3; i++){
            matrix.add(new Pair<>(random.nextInt(size),random.nextInt(size)));
        }
        
    }

    @Override
    public boolean toQuit() {
        
        return matrix.size() == (matrixSize*matrixSize);

    }

    @Override
    public Set<Pair<Integer, Integer>> positions() {
        Set<Pair<Integer,Integer>> s = new HashSet<>();
        s.addAll(matrix);
        return s;
    }

    @Override
    public void hit() {
       
        List<Pair<Integer,Integer>> tmp = new ArrayList<>();
        for(int i=0;i<matrixSize;i++){
            for(int j=0; j<matrixSize;j++){
                Pair<Integer,Integer> pair = new Pair<Integer,Integer>(j, i);
                if(matrix.stream().anyMatch( p -> Math.abs(p.getX() - pair.getX())<=1 && Math.abs(p.getY()-pair.getY())<=1)){
                    tmp.add(pair);
                }

            }
        }

        matrix.addAll(tmp);
        

    }
    
}
