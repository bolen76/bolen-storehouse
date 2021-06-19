package com.bolen.zk;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class DistributeServer {
    
    public static void main(String[] args) throws Exception {
        
        DistributeServer server = new DistributeServer();
        
        // 1 连接zookeeper集群
        server.getConnect();
        
        // 2 注册节点
        server.regist(args[0]);
        
        // 3 业务逻辑处理
        server.business();
    }
    
    private void business() throws InterruptedException {
        
        Thread.sleep(1000 * 60);
    }
    
    private void regist(String hostname) throws KeeperException, InterruptedException {
        
        String path = zkClient
                .create("/servers/server", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        
        System.out.println(hostname + "is online ");
        
    }
    
    private ZooKeeper zkClient;
    
    private void getConnect() throws IOException {
        
        zkClient = new ZooKeeper(ZkDemo.CONNECT_STRING, ZkDemo.SESSION_TIME_OUT, new Watcher() {
            
            @Override
            public void process(WatchedEvent event) {
                // TODO Auto-generated method stub
                
            }
        });
    }
}
