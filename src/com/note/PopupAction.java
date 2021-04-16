package com.note;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.psi.PsiFile;
import com.note.data.DataCenter;
import com.note.dialog.AddNotDialog;

/**
 * @author uatcd992786
 */
public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel model = editor.getSelectionModel();
        DataCenter.SELECT_TEXT = model.getSelectedText();
        PsiFile psiFile = e.getRequiredData(CommonDataKeys.PSI_FILE);
        DataCenter.FILE_NAME = psiFile.getViewProvider().getVirtualFile().getName();
        AddNotDialog addNotDialog = new AddNotDialog();
        addNotDialog.show();
    }
}
