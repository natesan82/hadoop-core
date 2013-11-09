package hadoop.mapper;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CFFriendMapper extends Mapper <LongWritable, Text, Text, Text> {

	public void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		StringTokenizer st = new StringTokenizer(line,":");
		String ckey = st.nextToken();
		String cvalue = st.nextToken();
		
		StringTokenizer st1 = new StringTokenizer(cvalue,",");
		while (st1.hasMoreTokens()) {
			String cvalelement = st1.nextToken();
			if (cvalelement.compareTo(ckey) > 0 ) {
				context.write(new Text(ckey + ":" + cvalelement), new Text(cvalue));
			}
			else {
				context.write(new Text(cvalelement + ":" + ckey), new Text(cvalue));
			}
		}
		
		

	}

}
