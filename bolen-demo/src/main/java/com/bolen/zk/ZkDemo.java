package com.bolen.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class ZkDemo {
    
    public static final String CONNECT_STRING = "192.168.153.141:2181,192.168.153.141:2182,192.168.153.141:2183";
    
    public static final int SESSION_TIME_OUT = 2000;
    
    private static ZooKeeper zkl;
    
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        zkl = new ZooKeeper(CONNECT_STRING, SESSION_TIME_OUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("--------------start-------------");
                List<String> children = null;
                try {
                    children = zkl.getChildren("/bolen", true);
                    for (String child : children) {
                        System.out.println(child);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--------------end-------------");
            }
        });
        Thread.sleep(1000000);
        System.out.println("----------------process finish-------------------------");
    }
    
    private static void watch() throws InterruptedException {
        try {
            List<String> children = zkl.getChildren("/bolen", true);
            for (String child : children) {
                System.out.println(child);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000000);
    }
    
    private static void testCreate() throws KeeperException, InterruptedException {
        String path = zkl.create("/bolen", "bolen hen shuai".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }
}
