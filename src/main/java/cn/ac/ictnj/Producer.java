package cn.ac.ictnj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

import static cn.ac.ictnj.NodeType.*;

public class Producer {

    public static NodeDiscoverMessage[] msgs = {
            new NodeDiscoverMessage("1", "127.0.0.1", CN_TP_Nokia_FDDLTE),
            new NodeDiscoverMessage("2", "127.0.0.2", CN_TP_Nokia_5GNR),
            new NodeDiscoverMessage("3", "127.0.0.3", AN_TP_Nokia_FDDLTE),
            new NodeDiscoverMessage("4", "127.0.0.4", AN_TP_Nokia_5GNR),
            new NodeDiscoverMessage("5", "127.0.0.5", AN_ICTNJ_FDDLTE),
            new NodeDiscoverMessage("6", "127.0.0.6", AN_ICTNJ_5GNR),
            new NodeDiscoverMessage("7", "127.0.0.7", AN_ICTNJ_NORMAL),
    };

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("nokiaAdapter||mano");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();
            for (int i = 0; i < msgs.length; i++) {
                Message msg = new Message("NodeDiscover", JSON.toJSONBytes(msgs[i]));
                try {
                    SendResult result = producer.send(msg);
                    System.out.println("返回结果: " + result);
                } catch (RemotingException e) {
                    e.printStackTrace();
                } catch (MQBrokerException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}
