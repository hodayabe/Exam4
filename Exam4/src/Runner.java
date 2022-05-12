import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		
				
		
		List<Tent> tents= new ArrayList<Tent>();
		tents.add(new Tent(1, 2.5, 2.5, 20.8));
		tents.add(new Tent(5, 5.3, 5, 12));
		tents.add(new Tent(13, 1, 17, 5));
		tents.add(new Tent(1, 17.2, 2.5, 2.5));
		tents.add(new Tent(11, 2.5, 2.5, 2.5));
		tents.add(new Tent(20, 2.5, 2.5, 2.5));
		tents.add(new Tent(4, 2.5, 2.5, 2.5));
		tents.add(new Tent(7, 2.5, 2.5, 2.5));
		tents.add(new Tent(30, 2.5, 2.5, 2.5));
		tents.add(new Tent(22, 2.5, 2.5, 2.5));

		
		List<Tent> tents1;

		tents.forEach(t->System.out.println(t));
		//1
		System.out.println("****list sorted by the area******");
		tents1= getCopySortedByArea(tents);
		tents1.forEach(t->System.out.println(t));
		
		//2
		System.out.println("****list sorted by numPeople******");
		tents1=sorByNumPeople(tents,2);
		tents1.forEach(t->System.out.println(t));
		
		//3
		System.out.println(sortBYHighest(tents,new Tent(22, 2.5, 40, 20.8)));
		
		
		//4
		
		 System.out.println("\r**************4************\r");
		Map<Double, List<Tent>> tempMap =getMapOfHeight(tents);
		 System.out.println(tempMap);
		 
		 //5
		 System.out.println("\r**************5************\r");
		 tents1=inRange(tempMap,30,15);
		 tents1.forEach(t->System.out.println(t));
		 
		 
		
	}
	
	//1
	public static List<Tent> getCopySortedByArea(List<Tent> tent){
		List<Tent> temp=null;
		temp=tent.stream().sorted((t1,t2)->{
			if(t1.getArea()==t2.getArea())
				return 0;
			
			if(t1.getArea()>t2.getArea())
				return 1;
			return -1;
		}).collect(Collectors.toList());
		
		return temp;
	}
	
	
	
	//2
	public static List<Tent> sorByNumPeople(List<Tent> tent,int max){
		List<Tent> temp=null;
		temp=tent.stream().filter(t1->t1.getNumPeople()>max)
				.sorted((t1,t2)-> t1.getNumPeople()-t2.getNumPeople())
				.collect(Collectors.toList());
		return temp;
	}
	
	
	
	//3
	public static boolean sortBYHighest(List<Tent> tent,Tent max){
		List<Tent> temp=null;
		
		temp=tent.stream().filter(t1->t1.getHeight() > max.getHeight())
				.collect(Collectors.toList());
		
		if(temp.size()==0)
			return true;
		return false;
	}
	
	
	
	//4
	public static Map<Double, List<Tent>> getMapOfHeight(List<Tent> tents){
		List<Tent> tempList=null;
		Map<Double, List<Tent>> tempMap = new HashMap<>();
	
		for (Iterator iterator = tents.iterator(); iterator.hasNext();) {
			Tent tent = (Tent) iterator.next();
			tempList=tents.stream().filter(t1->t1.getHeight()==tent.getHeight()).collect(Collectors.toList());
			tempMap.put(tent.getHeight(),tempList);
		}

		return tempMap;
	}
	
	
	
	
	
	//5
	
	public static List<Tent> inRange( Map<Double, List<Tent>> tentMap,double maxHeight,double mimHeight){
		List<Tent> tempList=new ArrayList<>();
		List<Tent> resList=new ArrayList<>();
		Set<Map.Entry<Double, List<Tent>>> entries = tentMap.entrySet();
		Iterator<Map.Entry<Double, List<Tent>>> iterator = entries.iterator();
		
		while(iterator.hasNext()) {
			 Map.Entry<Double, List<Tent>> entry = iterator.next();
			 tempList=entry.getValue().stream().filter(t-> t.getHeight() >= mimHeight)
					 .filter(t-> t.getHeight() <= maxHeight)
					 .collect(Collectors.toList());
			 resList.addAll(tempList);
		}
		return resList;
	}
	
	
	
	
	

}
