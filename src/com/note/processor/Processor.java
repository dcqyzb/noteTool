package com.note.processor;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author uatcd992786
 */
public interface Processor {
    /**
     * 执行生成文档
     *
     * @param sourceNoteData 数据封装
     * @throws IOException       e
     * @throws TemplateException e
     */
    void process(SourceNoteData sourceNoteData) throws IOException, TemplateException;
}
