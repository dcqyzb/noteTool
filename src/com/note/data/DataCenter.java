package com.note.data;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.ui.MessageType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author uatcd992786
 */
public class DataCenter {
    public static String SELECT_TEXT;
    public static String FILE_NAME;
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    /**
     * 表格表头初始化
     */
    public static String[] TABLE_HEAD = {"标题", "备注", "文件名", "代码段"};
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null, TABLE_HEAD);

    /**
     * 到处文件类型下拉框初始化
     */
    public static final String[] FILE_TYPE = {"HTML(*.html)", "MackDown(*.md)"};
    public static DefaultComboBoxModel<String> COM_BO_BOX_MODEL = new DefaultComboBoxModel<>(FILE_TYPE);

    public static void reset() {
        NOTE_LIST.clear();
        TABLE_MODEL.setDataVector(null, TABLE_HEAD);
    }

    /**
     * 通用提示信息
     *
     * @param content 提示内容
     * @param logLve  提示信息级别
     */
    public static void dialog(String content, MessageType logLve) {
        NotificationGroup notificationGroup = new NotificationGroup("markBook_id", NotificationDisplayType.BALLOON, true);
        Notification notification = notificationGroup.createNotification(content, logLve);
        Notifications.Bus.notify(notification);
    }
}
