package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

 

public class LogicsImpl implements Logics {

	private class ButtonImpl {

		private final int index;
		private int value;
		private boolean enabled = true;

		public ButtonImpl(int index,int value){
			this.index=index;
			this.value=value;
		}

		public int getValue() {
			return value;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setValue(){
			this.value++;
		}

		public void setFalse(){
			this.enabled=false;
		}

	}

	private final int size;
	private List<ButtonImpl> list = new ArrayList<>();

	public LogicsImpl(int size) {
		this.size = size;
		for(int i=0;i<this.size;i++){
			list.add(new ButtonImpl(i, 0));
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		return list.stream().map(v -> v.getValue()).toList();
	}

	@Override
	public List<Boolean> enablings() {
		return list.stream().map(v -> v.isEnabled()).toList();
	}

	@Override
	public int hit(int elem) {
		list.get(elem).setValue();
		if(list.get(elem).getValue()==size){
			list.get(elem).setFalse();
		}
		return list.get(elem).getValue();
	}

	@Override
	public String result() {
		return list.stream().map(v-> String.valueOf(v.getValue())).collect(Collectors.joining("|","<<",">>"));
	}

	@Override
	public boolean toQuit() {
		return list.stream().allMatch( v -> v.getValue() == list.get(0).getValue());
	}
}
