package com.note.window;

import com.note.data.DataCenter;
import com.note.data.TempleTypeEnum;
import com.note.processor.DefaultSourceNoteData;
import com.note.processor.FreeMarkProcessor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.io.File;

/**
 * @author uatcd992786
 */
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbContent;
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JPanel contentPanel;
    private JComboBox<String> fileType;

    private void init() {
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
        tfTopic.setText("");
        fileType.setModel(DataCenter.COM_BO_BOX_MODEL);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        btnCreate.addActionListener(e -> {
            int selectedIndex = fileType.getSelectedIndex();
            TempleTypeEnum templeTypeEnum = selectedIndex == 0 ? TempleTypeEnum.HTML_TYPE : TempleTypeEnum.MACK_DOWN_TYPE;
            String topic = tfTopic.getText();
            String fileName = topic + templeTypeEnum.getFileType();
            if (null == topic || "".equals(topic)) {
                DataCenter.dialog("文档标题没有输入", MessageType.WARNING);
                return;
            }
            if (DataCenter.NOTE_LIST.isEmpty()) {
                DataCenter.dialog("请添加文档笔记", MessageType.WARNING);
                return;
            }
            VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getProjectFile());
            if (null != virtualFile) {
                String path = virtualFile.getPath();
                String fileFullPath = path + File.separator + fileName;
                FreeMarkProcessor processor = new FreeMarkProcessor();
                try {
                    DefaultSourceNoteData defaultSourceNoteData = new DefaultSourceNoteData(fileFullPath, topic, DataCenter.NOTE_LIST, templeTypeEnum);
                    processor.process(defaultSourceNoteData);
                    DataCenter.dialog("生成文档成功：" + fileFullPath, MessageType.INFO);
                } catch (Exception ex) {
                    DataCenter.dialog(ex.getMessage(), MessageType.ERROR);
                    ex.printStackTrace();
                }
            }
        });
        btnClear.addActionListener(e -> {
            tfTopic.setText("");
            DataCenter.reset();
        });
        btnClose.addActionListener(e -> toolWindow.hide());
    }


    public JPanel getContentPanel() {
        return contentPanel;
    }
}
