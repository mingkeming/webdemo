package com.renjack.webdemo.likou;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.io.IOException;
import java.util.*;

/**
 * @program: webdemo
 * @description: 利扣4
 * @author: Jack
 * @create: 2021-02-12 22:16
 **/
public class Solution {

    public static void main(String[] args) throws IOException {
new MyProducer().start();

        new MyConsumer().start();
    }

}


class MyProducer extends Thread{

    @Override
    public void run() {
        // 1.配置信息
        Properties props = new Properties();
        // 定义kafka服务器地址列表，不需要指定所有的broker
        props.put("bootstrap.servers", "192.168.78.139:9092");
        //  生产者需要leader确认请求完成之前接收的应答数
        props.put("acks", "-1");


        // 客户端失败重试次数
        props.put("retries", 1);
        // 生产者打包消息的批量大小，以字节为单位.此处是16k
        props.put("batch.size", 16384);
        // 生产者延迟1ms发送消息
        props.put("linger.ms", 1);
        // 生产者缓存内存的大小，以字节为单位.此处是32m
        props.put("buffer.memory", 33554432);
        // key 序列化类
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化类
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 2.创建生产者
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(props);

        // 3.生产数据
        /**
         * 发送消息的三种方式：
         *      1.同步阻塞发送
         *          适用场景：业务不需要高吞吐量、更关心消息发送的顺序、不允许消息发送失败
         *      2.异步发送（发送并忘记）
         *          适用场景：业务只关心吞吐量、不关心消息发送的顺序、可以允许消息发送失败
         *      3.异步发送（回调函数）
         *          适用场景：业务需要知道消息发送成功、不关心消息发送的顺序
         */

        // 1.同步阻塞发送
        // 创建消息
       /* System.out.println("-------------------同步发送消息......start-----------------------");
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("itheima_topic",0,"key-sync","同步发送消息");

        Future<RecordMetadata> send = producer.send(record);
        RecordMetadata recordMetadata = send.get();
        System.out.println(recordMetadata);//itheima_topic-0@2

        System.out.println("-------------------同步发送消息......end-----------------------");*/

        // 2.异步发送（发送并忘记）
        // 创建消息
        /*System.out.println("-------------------异步发送（发送并忘记）......start-----------------------");
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("itheima_topic",0,"key-async1","异步发送消息，发送并忘记");

        // 发送并忘记
        producer.send(record);

        System.out.println("-------------------异步发送（发送并忘记）......end-----------------------");

        // 刷新
        producer.flush();*/

        // 3.异步发送（回调函数）
        // 创建消息
        System.out.println("-------------------异步发送（回调函数）......start-----------------------");
        int count = 0;
        while (true){
            for(int i = 0; i < 5; i++){
                ProducerRecord<String,String> record = new ProducerRecord<String, String>("quickstart-events",0,"key-async2","异步发送消息，（回调函数）" + count++);

                // 处理回调业务逻辑
                producer.send(record, (recordMetadata, e) -> {
//                        System.out.println("异步发送消息成功："+recordMetadata);
//                        System.out.println("异常对象："+e);//null
                });
            }

            try {
                sleep(5000L);
            } catch (InterruptedException e) {

            }

        }
        // 发送，回调函数处理

//
//        System.out.println("-------------------异步发送（回调函数）......end-----------------------");
//
//        // 刷新
//        producer.flush();
    }
}

class MyConsumer extends Thread{

    @Override
    public void run(){
        // 1.配置信息
        Properties props = new Properties();
        // 定义kafka服务器地址列表，不需要指定所有的broker
        props.put("bootstrap.servers", "192.168.78.139:9092");
        // 消费者组id
        props.put("group.id", "itheima");
        // 是否自动确认offset
        props.put("enable.auto.commit", "true");
        //自动确认offset时间间隔
        props.put("auto.commit.interval.ms", "1000");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        // key 序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        // 2.创建消费者
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(props);

        // 3.消费消息
        // 指定分区消费
        TopicPartition partition = new TopicPartition("quickstart-events",0);

        // 获取已经提交的偏移量
        long offset = 0L;
        OffsetAndMetadata offsetAndMetadata = consumer.committed(partition);
        if(offsetAndMetadata !=null){
            offset = offsetAndMetadata.offset();
        }
        System.out.println("当前消费的偏移量："+offset);

        // 指定偏移量消费
        consumer.assign(Arrays.asList(partition));
        consumer.seek(partition,offset);
         int count = 0;
        // 循环拉取数据
        while (true){
            // 拉取数据
            ConsumerRecords<String, String> records = consumer.poll(10000);

            // 打印数据
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("消费的数据为：-----------------------------------------------------------" + record.value());
            }

            System.out.println("times:" + count++);
            consumer.commitSync();
        }
    }
}
