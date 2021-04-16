package com.note.processor;

import com.note.data.NoteData;
import com.note.data.TempleTypeEnum;

import java.util.List;

/**
 * @author uatcd992786
 */
public interface SourceNoteData {
    /**
     * 获取文件名
     *
     * @return 文件名
     */
    String getFileName();

    /**
     * 获取文档标题
     *
     * @return 文档标题
     */
    String getTopic();

    /**
     * 文件类型模板
     *
     * @return 文件类型模板枚举
     */
    TempleTypeEnum getTempleType();

    /**
     * 笔记记录列表
     *
     * @return 笔记记录列表
     */
    List<NoteData> getNoteList();
}
