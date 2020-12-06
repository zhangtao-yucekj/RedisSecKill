package com.tao.demo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.stereotype.Component;

@Component
public class ZookeeperWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
