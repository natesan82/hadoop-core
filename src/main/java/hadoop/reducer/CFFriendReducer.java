package hadoop.reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CFFriendReducer extends Reducer <Text, Text, Text, Text> {
	
	public void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException {
		
		List<Text> list = new ArrayList<Text>();
		System.out.println("XXXXXXXXXXXXX");
		for(Text val:value){
			list.add(new Text(val));
		}
		System.out.println("YYYYYYYYYYYY");
		Set<String> ss = new HashSet<String>();
		Text A = list.get(0);
		StringTokenizer st = new StringTokenizer(A.toString(),",");
		while(st.hasMoreTokens()) {
			String a = st.nextToken();
			ss.add(a);
		}
		
		Set<String> ss1 = new HashSet<String>();
		Text B = list.get(1);
		StringTokenizer st1 = new StringTokenizer(B.toString(),",");
		while(st1.hasMoreTokens()) {
			String b = st1.nextToken();
			ss1.add(b);
		}
		
		System.out.println("ZZZZZZZZZZZZZZ");
		ss.retainAll(ss1);
		System.out.println("--------------");
		context.write(key, new Text(ss.toString()));
		
				}

}
