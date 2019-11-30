package cn.com.blackview.lddialog.manager;


import java.util.concurrent.ConcurrentLinkedQueue;

import cn.com.blackview.lddialog.LDDialog;

/**
 * 支持多个Dialog依次弹出
 * Created by mq on 2018/9/1 下午4:35
 * mqcoder90@gmail.com
 */

public class LDDialogsManager {

    private volatile boolean showing = false;//是否有dialog在展示
    private ConcurrentLinkedQueue<DialogWrapper> dialogQueue = new ConcurrentLinkedQueue<>();

    private LDDialogsManager() {
    }

    public static LDDialogsManager getInstance() {
        return DialogHolder.instance;
    }

    private static class DialogHolder {
        private static LDDialogsManager instance = new LDDialogsManager();
    }

    /**
     * 请求加入队列并展示
     *
     * @param dialogWrapper DialogWrapper
     * @return 加入队列是否成功
     */
    public synchronized boolean requestShow(DialogWrapper dialogWrapper) {
        boolean b = dialogQueue.offer(dialogWrapper);
        checkAndDispatch();
        return b;
    }

    /**
     * 结束一次展示 并且检查下一个弹窗
     */
    public synchronized void over() {
        showing = false;
        next();
    }

    private synchronized void checkAndDispatch() {
        if (!showing) {
            next();
        }
    }

    /**
     * 弹出下一个弹窗
     */
    private synchronized void next() {
        DialogWrapper poll = dialogQueue.poll();
        if (poll == null) return;
        LDDialog.Builder dialog = poll.getDialog();
        if (dialog != null) {
            showing = true;
            dialog.show();
        }
    }


}
