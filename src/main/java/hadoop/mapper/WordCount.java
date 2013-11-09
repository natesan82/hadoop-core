package hadoop.mapper;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCount extends Mapper <LongWritable, Text, Text, IntWritable>{

		private IntWritable i = new IntWritable(1);
		private Text word = new Text();
		
	public void map(LongWritable Key, Text Value, Context context) throws IOException, InterruptedException {
		
		
		String line = Value.toString();
		StringTokenizer st = new StringTokenizer(line);
		
		while (st.hasMoreTokens()) {
			word.set(st.nextToken());
			context.write(word,i);
		}
			
	}

}
