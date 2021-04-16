package com.note.processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author uatcd992786
 */
public class FreeMarkProcessor extends AbstractFreeMarkProcessor {

    @Override
    protected Template getTemplate(SourceNoteData sourceNoteData) throws IOException {
        Configuration configuration = new Configuration();
        String templateContent = UrlUtil.loadText(FreeMarkProcessor.class.getResource(sourceNoteData.getTempleType().getTemplePath()));
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("fileTemplate", templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);
        return configuration.getTemplate("fileTemplate");
    }

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map<String, Object> model = new HashMap<>(2);
        model.put("topic", sourceNoteData.getTopic());
        model.put("noteList", sourceNoteData.getNoteList());
        return model;
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
    }
}
