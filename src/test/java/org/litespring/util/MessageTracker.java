package org.litespring.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qingge on 2019/4/29.
 */
public class MessageTracker {
    private static List<String> MESSAGES = new ArrayList<String>();

    public static void addMsg(String msg){
        MESSAGES.add(msg);
    }
    public static void clearMsgs(){
        MESSAGES.clear();
    }
    public static List<String> getMsgs(){
        return MESSAGES;
    }
}
