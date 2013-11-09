package hadoop.driver;

import hadoop.mapper.CFFriendMapper;
import hadoop.reducer.CFFriendReducer;
import hadoop.reducer.WordCountReducer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class CFriendDriver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Configuration conf = new Configuration();
		//System.setProperty("HADOOP_USER_NAME", "root");


		Job job = new Job(conf, "cfriend");

		job.setJarByClass(CFriendDriver.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//job.setCombinerClass(WordCountReducer.class);

		job.setMapperClass(CFFriendMapper.class);
		job.setReducerClass(CFFriendReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path("C:/Natesan/EclipseFiles/CFFile.txt"));
		FileOutputFormat.setOutputPath(job, new Path("C:/Natesan/EclipseFiles/CFMOP3"));

		job.waitForCompletion(true);
	}
	}

