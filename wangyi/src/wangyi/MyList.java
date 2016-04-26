package wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.ArrayList;

public class MyList {

	public static void main(String[] args) {
		List<Integer> array=new ArrayList<>();
		array.add(3);
		array.add(6);
		array.add(0,8);
		array.remove(0);
		
		ListIterator<Integer> iter=array.listIterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		System.out.println(array.get(1));
		
		//System.out.println(linked.get(1));
//		for(Integer i:linked){
//			System.out.println(i);
//		}
//		
//		linked.stream().forEach((i)->System.out.println(i));
		
//		ListIterator<Integer> iterator=(ListIterator<Integer>) linked.iterator();
//		
//		while(iterator.hasNext()){
//			
//			System.out.println(iterator.nextIndex());
//			iterator.next();
//			//iterator.remove();
//		}
//		
//		System.out.println("after removing");
//		while(ite ator.hasNext()){
//			 
//			System.out.println(iterator.next());
//			
//		}
		
//		Optional<String> optional=Optional.of("a");
//		optional=Optional.ofNullable(null);
//		System.out.println(optional.orElseGet(()->"default"));
	}

}
