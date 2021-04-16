package com.note.data;

/**
 * 模板类型枚举类
 */
public enum TempleTypeEnum {
    /**
     * html文件类型
     */
    HTML_TYPE(".html", "/template/htm.ftl"),
    /**
     * mackDow文件类型
     */
    MACK_DOWN_TYPE(".md", "/template/md.ftl");

    private String fileType;
    private String templePath;

    TempleTypeEnum(String fileType, String templePath) {
        this.fileType = fileType;
        this.templePath = templePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTemplePath() {
        return templePath;
    }

    public void setTemplePath(String templePath) {
        this.templePath = templePath;
    }
}
