package hadoop.driver;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapred.lib.IdentityReducer;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import hadoop.mapper.WordCount;
import hadoop.reducer.WordCountReducer;

public class WordCountDriver {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Configuration conf = new Configuration();
		//System.setProperty("HADOOP_USER_NAME", "root");


		Job job = new Job(conf, "wordcount");

		job.setJarByClass(WordCountDriver.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//job.setCombinerClass(WordCountReducer.class);

		job.setMapperClass(WordCount.class);
		job.setReducerClass(WordCountReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path("C:/Natesan/EclipseFiles/WCInput.txt"));
		FileOutputFormat.setOutputPath(job, new Path("C:/Natesan/EclipseFiles/WCOutput3"));

		job.waitForCompletion(true);
	}
	}

