package com.note.dialog;

import com.note.data.DataCenter;
import com.note.data.DataConvert;
import com.note.data.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author uatcd992786
 */
public class AddNotDialog extends DialogWrapper {
    private EditorTextField tfTitle;
    private EditorTextField tfMark;
    public static final String SUCCESS = "添加成功";

    public AddNotDialog() {
        super(true);
        init();
        setTitle("添加笔记");
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        tfTitle = new EditorTextField("笔记标题");
        tfMark = new EditorTextField("笔记内容");
        tfMark.setPreferredSize(new Dimension(200, 100));
        panel.add(tfTitle, BorderLayout.NORTH);
        panel.add(tfMark, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("添加笔记到列表");
        button.addActionListener(e -> {
            String title = tfTitle.getText();
            String mark = tfMark.getText();
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark, DataCenter.SELECT_TEXT, DataCenter.FILE_NAME, fileType);
            DataCenter.NOTE_LIST.add(noteData);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
            MessageDialogBuilder.yesNo("操作结果", SUCCESS);
            AddNotDialog.this.dispose();
        });
        panel.add(button);
        return panel;
    }
}
