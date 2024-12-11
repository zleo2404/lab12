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
        
        if ( matrix.get(x.getX()).get(x.getY()) == true){
            matrix.get(x.getX()).set(x.getY(),false);
        }else{
            matrix.get(x.getX()).set(x.getY(),true);
        }

        return matrix.get(x.getX()).get(x.getY());
        

    }

    @Override
    public boolean toQuit() {
        
        boolean condition=false;;
        condition=checkRows();
        if(condition){
            return true;
        }else{
            return condition=checkColumns();
        }

    }

    private boolean checkColumns() {
        boolean check=true;
        for(int i=0; i<matrix.size() ; i++){
            check=true;
            for(int j=0; j<matrix.size();j++){
                if(!matrix.get(j).get(i)==true){
                    check=false;
                }
            }
            if(check) return true;
        }
        return check;
    }

    private boolean checkRows() {
        
        return matrix.stream().anyMatch( v -> v.stream().allMatch(b -> b==true));

    }
    
}
