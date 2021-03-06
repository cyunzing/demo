package com.zing.action.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * zookeeper 恢复之前的会话连接demo演示
 */
public class ZKConnectSessionWatcher implements Watcher {

    final static Logger log = LoggerFactory.getLogger(ZKConnectSessionWatcher.class);

    private final static String ZK_SERVER_PATH = "hadooooop:2181";
    private final static Integer TIMEOUT = 5000;

    public void process(WatchedEvent event) {
        log.warn("接受到watch通知：{}", event);
    }

    public static void main(String[] args) {

        try {
            ZooKeeper zk = new ZooKeeper(ZK_SERVER_PATH, TIMEOUT, new ZKConnectSessionWatcher());

            long sessionId = zk.getSessionId();
            byte[] sessionPasswd = zk.getSessionPasswd();

            String ssid = "0x" + Long.toHexString(sessionId);
            System.out.println(ssid);

            log.warn("客户端开始连接zookeeper服务器...");
            log.warn("连接状态：{}", zk.getState());

            Thread.sleep(1000);

            log.warn("连接状态：{}", zk.getState());

            Thread.sleep(200);

            // 开始会话重连
            log.warn("开始会话重连...");

            ZooKeeper zkSession = new ZooKeeper(ZK_SERVER_PATH,
                    TIMEOUT,
                    new ZKConnectSessionWatcher(),
                    sessionId,
                    sessionPasswd);

            log.warn("重新连接状态zkSession：{}", zkSession.getState());

            Thread.sleep(1000);

            log.warn("重新连接状态zkSession：{}", zkSession.getState());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
