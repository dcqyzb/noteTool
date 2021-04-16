package com.note.processor;

import com.note.data.NoteData;
import com.note.data.TempleTypeEnum;

import java.util.List;

/**
 * @author uatcd992786
 */
public class DefaultSourceNoteData implements SourceNoteData {

    private String fileName;
    private String topic;
    private List<NoteData> noteList;
    private TempleTypeEnum templeType;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteDataList, TempleTypeEnum templeType) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteDataList;
        this.templeType = templeType;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public TempleTypeEnum getTempleType() {
        return templeType;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }
}
