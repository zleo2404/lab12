package it.unibo.es2;

import java.util.LinkedList;
import java.util.List;

public class LogicsImpl implements Logics{

    List<List<Boolean>> matrix;

    public LogicsImpl(int size){
        matrix=new LinkedList<>();
        for(int i=0; i < size; i++){
            matrix.add(new LinkedList<>());
            for(int j=0; j < size; j++){
                matrix.get(i).add(false);
            }
        }
        
    }

    @Override
    public boolean hit(Pair<Integer, Integer> x) {
        
        if ( matrix.get(x.getY()).get(x.getX()) == true){
            matrix.get(x.getY()).set(x.getX(),false);
        }else{
            matrix.get(x.getY()).set(x.getX(),true);
        }

        return matrix.get(x.getY()).get(x.getX());
        

    }

    @Override
    public boolean toQuit() {
        
        

    }
    
}
