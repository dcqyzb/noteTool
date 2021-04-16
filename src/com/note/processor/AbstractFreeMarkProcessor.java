package com.note.processor;


import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

/**
 * @author uatcd992786
 */
public abstract class AbstractFreeMarkProcessor implements Processor {

    /**
     * 获取模板
     *
     * @param sourceNoteData – 数据封装
     * @return Template
     * @throws IOException e
     */
    protected abstract Template getTemplate(SourceNoteData sourceNoteData) throws IOException;

    /**
     * 获取数据model
     *
     * @param sourceNoteData 数据封装
     * @return object
     */
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    /**
     * 获取文件
     *
     * @param sourceNoteData 数据封装
     * @return Write
     * @throws FileNotFoundException e
     */
    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException;

    @Override
    public final void process(SourceNoteData sourceNoteData) throws IOException, TemplateException {
        Template template = getTemplate(sourceNoteData);
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        template.process(model, writer);
    }
}
