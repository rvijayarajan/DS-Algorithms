import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class ArrayManipulation {
	static int longestValue = 0;
	public static void main(String[] args) throws IOException {
		int[][] queries = {
			{1,2,100},
			{2,5,100},
			{3,4,100}
		};
		int a[] = new int[5];
		int n = a.length;
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		System.out.println("Input Array");
		for (int i=0; i< n; i++) {
			System.out.println(a[i]);
		}
		System.out.println("Starting To Process Queries");
		for(int i=0; i<queries.length; i++) {
			int[] query = queries[i];
			System.out.println(query[0]+":"+query[1]+":"+query[2]);
			IntStream.rangeClosed(query[0]-1, query[1]-1).forEach(j -> {
				a[j] = a[j] + query[2];
				if(a[j]>ArrayManipulation.longestValue) {
					ArrayManipulation.longestValue = a[j];
				}
			});
			// Set<Map.Entry<Integer,String>> entries = map.entrySet();
			// Iterator<Map.Entry<Integer,String>> entryIterator = entries.iterator();
			// if(entryIterator.hasNext()) {
			// 	while(entryIterator.hasNext()) {
			// 		Map.Entry<Integer,String> entry = entryIterator.next();
			// 		String r = entry.getValue();
			// 		String[] range = r.split("->");
			// 		System.out.println(range[0]);
			// 		System.out.println(range[1]);
			// 		if(query[0]<range[1])
			// 	}	
			// } else {
			// 	map.put(query[2],query[0]+"->"+query[1]);
			// }
			
		}
		System.out.println("Output Value");
		System.out.println(ArrayManipulation.longestValue);
	}
}