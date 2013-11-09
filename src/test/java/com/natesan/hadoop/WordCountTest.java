package com.natesan.hadoop;

import static org.junit.Assert.*;
import hadoop.mapper.WordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;

public class WordCountTest {

	@Test
	public void testmap() {
		Text Value = new Text ("Natesan");
		WordCount wc = new WordCount();
		
		LongWritable one = new LongWritable(1);
		
		new MapDriver<LongWritable, Text, Text, IntWritable>()
	      .withMapper(new WordCount())
	      .withInputValue(Value)
	      .withInputKey(one)
	      .withOutput(new Text("Natesan"), new IntWritable(2))
	      .runTest();
	}

}
