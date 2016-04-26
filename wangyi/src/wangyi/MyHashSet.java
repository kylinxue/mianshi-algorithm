package wangyi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *  如果一个自定义类作为HashMap的key时，必须重写其hashCode方法和equals方法
 * @author kylinxue
 *
 */
public class MyHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Name> set=new HashSet<>();
		Name Li=new Name("xue", "kylin");
		set.add(Li);
		set.add(new Name("xue","rulin"));
		
		Iterator iter=set.iterator();
		while(iter.hasNext()){
			Name name=(Name)iter.next();
			name.firstName="hello";
			//set.add(new Name("hello1","wworld"));
			System.out.println(name.firstName);
		}
		
		LinkedList<Integer> list=new LinkedList<>();
		
		
//		HashMap<String, Integer> map=new HashMap<>();
//		map.put("1", 11);
//		map.put("2", 22);
//		map.put("3", 33);
//		if(map.containsKey("2")){
//			map.remove("2");
//		}
//		
//		System.out.println(map.size());
	}

}

class Name{
	public String firstName;
	String secondName;
	public Name(String first, String second){
		this.firstName=first;
		this.secondName=second;
	}
	public int hashCode(){
		return firstName.hashCode();
	}
	public boolean equals(Name o){
		if(this==o){
			return true;
		}
		if(Name.class==o.getClass()){
			return this.firstName.equals(o.firstName)
					&& this.secondName.equals(o.secondName);
		}
		return false;
	}
}
