package hadoop.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class WordCountReducer extends Reducer <Text, IntWritable, Text, IntWritable>{
	
	public void reduce(Text Key, Iterable<IntWritable> Value, Context context) throws IOException, InterruptedException {
		
		int i = 0;
	
		for (IntWritable val:Value) {
			i += val.get();	
		}
		context.write(Key,new IntWritable(i));

	}


}
