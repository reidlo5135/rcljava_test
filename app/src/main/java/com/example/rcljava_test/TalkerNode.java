package com.example.rcljava_test;

import android.util.Log;
import org.ros2.rcljava.node.BaseComposableNode;
import org.ros2.rcljava.publisher.Publisher;
import org.ros2.rcljava.timer.WallTimer;

import java.util.concurrent.TimeUnit;

public class TalkerNode extends BaseComposableNode {

    private static String logtag = TalkerNode.class.getName();

    private final String topic;

    public Publisher<std_msgs.msg.String> publisher;

    private int count;

    private WallTimer timer;

    public TalkerNode(final String name, final String topic) {
        super(name);
        this.topic = topic;
        this.publisher = this.node.<std_msgs.msg.String>createPublisher(
                std_msgs.msg.String.class, this.topic);
    }

    public void start() {
        Log.d(logtag, "TalkerNode::start()");
        if (this.timer != null) {
            this.timer.cancel();
        }
        this.count = 0;
        this.timer = node.createWallTimer(500, TimeUnit.MILLISECONDS, this ::onTimer);
    }

    private void onTimer() {
        std_msgs.msg.String msg = new std_msgs.msg.String();
        msg.setData("Hello ROS2 from Android: " + this.count);
        this.count++;
        this.publisher.publish(msg);
    }

    public void stop() {
        Log.d(logtag, "TalkerNode::stop()");
        if (this.timer != null) {
            this.timer.cancel();
        }
    }
}
