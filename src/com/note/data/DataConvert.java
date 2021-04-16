package com.note.data;

/**
 * @author uatcd992786
 */
public class DataConvert {
    /**
     * 数据格转化string[]
     *
     * @param noteData 笔记数据
     * @return string[]
     */
    public static String[] convert(NoteData noteData) {
        String[] row = new String[4];
        row[0] = noteData.getTitle();
        row[1] = noteData.getMark();
        row[2] = noteData.getFileName();
        row[3] = noteData.getContent();
        return row;
    }
}
