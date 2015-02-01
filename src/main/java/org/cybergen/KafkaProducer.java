package org.cybergen;

import kafka.javaapi.producer.Producer;
import kafka.javaapi.producer.ProducerData;
import kafka.producer.ProducerConfig;
import org.apache.commons.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by suresh on 12/11/14.
 */
public class KafkaProducer {
    private static Properties props;
    private static String topic;
    private static String zkConnect;
    private static ExecutorService executor;
    private static ProducerConfig producerConfig;
    private static Producer producer;
    private final static KafkaProducer INSTANCE = new KafkaProducer();
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    private KafkaProducer() {
        //singleton implementation
    }

    public static KafkaProducer getInstance() {
        return INSTANCE;
    }

    public void produce(String JsonMsg) {
        final String constmsg = JsonMsg;
        executorService.execute(new Runnable() {
            public void run() {
                List<String> message = new ArrayList<String>();
                message.add(constmsg);
                ProducerData<String, String> data = new ProducerData<String, String>("userDataHack", "producerkey",message);
                producer.send(data);
            }
        });
    }
    //
    public static void log(String message){
                getInstance().produce(message);
    }
    public static void initialize(Configuration config) {
        props = new Properties();
        zkConnect = config.getString("userdata.updater.zk.connect","127.0.0.1:2181");
        props.put("zk.connect",zkConnect);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        producerConfig = new ProducerConfig(props);
        producer = new Producer(producerConfig);
        topic = config.getString("userdata.updater.kafka.topic","userDataHack");
    }

    public static void close() {
        producer.close();
    }
}