package it.unibo.es3;

import java.util.HashSet;
import java.util.LinkedList;
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
            matrix.add(new Pair<>(random.nextInt(),random.nextInt()));
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
    public void checkNeighborns() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkNeighborns'");
    }

    @Override
    public void hit() {
       
        for(int i=0; i< matrixSize; i++){
            for(int j=0; j<matrixSize;j++){
                
            }
        }

    }
    
}
