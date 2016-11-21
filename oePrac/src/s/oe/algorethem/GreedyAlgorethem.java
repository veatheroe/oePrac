package s.oe.algorethem;

import java.util.ArrayList;
import java.util.Random;

class GreedyAlgorethem {
	ArrayList<MonitorInterval> list;
	static GreedyAlgorethem ga;
	public static GreedyAlgorethem init(){
		if(ga!=null)
			return ga;
		else
			return ga = new GreedyAlgorethem();
	}
	private void quickSorting(ArrayList<MonitorInterval> list,int left, int right){
		if(left<right){
			MonitorInterval key = list.get(left);
			int low = left;
			int high = right;
			while(low<high){
				while(low<high && list.get(high).getEnd()>key.getEnd()){
					high--;
				}
				list.set(low, list.get(high));
				while(low<high && list.get(low).getEnd() < key.getEnd()){
					low++;
				}
				list.set(high, list.get(low));
			}
			list.set(low, key);
			quickSorting(list,left,low-1);
			quickSorting(list,low+1,right);
		}
	}
	private ArrayList<MonitorInterval> greedyScheduling(ArrayList<MonitorInterval> list ){
		ArrayList<MonitorInterval> gList = new ArrayList<MonitorInterval>();
		int index = 0;
		while(index<list.size()){
			gList.add(list.get(index));
			while(++index<list.size() && gList.get(gList.size()-1).getEnd()>list.get(index).getStart());
			
		}
		return gList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		GreedyAlgorethem ga = GreedyAlgorethem.init();
		ga.list = new ArrayList<MonitorInterval>();
		for(int i=0;i<10;i++){
			int ran1 = ran.nextInt(100);
			int ran2 = ran.nextInt(100);
			ga.list.add(new MonitorInterval(ran1<=ran2?ran1:ran2,ran1<=ran2?ran2:ran1));
		}
		for(int i=0;i<ga.list.size();i++)
			System.out.print("num:"+i+"["+ga.list.get(i).getStart()+","+ga.list.get(i).getEnd()+"]   ");
		ga.quickSorting(ga.list, 0,ga.list.size()-1);
		System.out.println("");
		for(int i=0;i<ga.list.size();i++)
			System.out.print("num:"+i+"["+ga.list.get(i).getStart()+","+ga.list.get(i).getEnd()+"]   ");
		ga.list = ga.greedyScheduling((ga.list));
		System.out.println("");
		for(int i=0;i<ga.list.size();i++)
			System.out.print("num:"+i+"["+ga.list.get(i).getStart()+","+ga.list.get(i).getEnd()+"]   ");

	}

}
