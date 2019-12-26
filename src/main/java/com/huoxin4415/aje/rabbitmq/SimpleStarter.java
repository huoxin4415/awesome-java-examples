package com.huoxin4415.aje.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 连接MQ实例 
 * 1.创建ConnectionFactory 
 * 2.创建Connection&channel 
 * 3.声明exchange&queue
 * 4.publish message 
 * 5.consume message
 */
public class SimpleStarter {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        // 方式1
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        // 方式2
        // factory.setUri("amqp://userName:password@hostName:portNumber/virtualHost");

        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        final String exchangeName = "amq.topic";
        final String routingKey = "topic.test";

        // 创建exchange，默认amq.direct已存在，不再创建
        // channel.exchangeDeclare(exchangeName, "direct", true);

        String queueName = channel.queueDeclare().getQueue();
        // 创建临时&排他队列
        // channel.queueBind(queueName, exchangeName, routingKey);

        // publish message
        byte[] messageBodyBytes = "Hello, world!".getBytes();
        channel.basicPublish(exchangeName, routingKey, 
                new AMQP.BasicProperties.Builder().type("example.hello").build(),   // set properties
                messageBodyBytes);
        System.out.println("publish message:" + new String(messageBodyBytes));

        // consume message
        boolean autoAck = false;
        String consumerTag = channel.basicConsume(queueName, autoAck, "myConsumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println("consume message:" + new String(body));
                System.out.println("properties type:" + properties.getType()); // get properties
                channel.basicAck(deliveryTag, true);
            }
        });

        System.out.println("Click anything to close...");
        System.in.read();

        channel.basicCancel(consumerTag);   // cancel consumer

        channel.close();
        conn.close();
    }
}