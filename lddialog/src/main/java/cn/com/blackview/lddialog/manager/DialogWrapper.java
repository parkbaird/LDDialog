package cn.com.blackview.lddialog.manager;


import cn.com.blackview.lddialog.LDDialog;

/**
 * 管理多个dialog 按照dialog的优先级依次弹出
 * Created by mq on 2018/9/16 下午9:44
 * mqcoder90@gmail.com
 */

public class DialogWrapper {

    private LDDialog.Builder dialog;//统一管理dialog的弹出顺序

    public DialogWrapper(LDDialog.Builder dialog) {
        this.dialog = dialog;
    }

    public LDDialog.Builder getDialog() {
        return dialog;
    }

    public void setDialog(LDDialog.Builder dialog) {
        this.dialog = dialog;
    }

}
