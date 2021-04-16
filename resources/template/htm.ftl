<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${topic}</title>
</head>
<style type="text/css">
    #noteDiv {
        width: 70%;
        margin: auto;
    }

    .textareaContent {
        width: 900px;
        height: 300px;
        margin: 0 0 0 70px;
    }

    #nav {
        z-index: 999;
        position: fixed;
        top: 23px;
        right: 403px;
    }

    .fileType {
        margin-left: 20px;
    }

    #title {
        width: 100%;
        text-align: center;
    }

    #content {
        width: 80%;
    }
</style>
<body>
<div id="noteDiv">
    <div id="content">
        <div id="title">
            <h1>${topic}</h1>
        </div>
        <h4>[TOC]</h4>
        <#list noteList as note>
            <div id="note_${note_index + 1}">
                <h3>${note_index + 1}、${note.title}</h3>
                <ol>
                    <li><strong>描述：</strong>${note.mark}</li>
                    <li><strong>文件名：</strong>${note.fileName}</li>
                </ol>
                <#if note.content ??>
                    <strong class="fileType">文件名类型：</strong>${note.fileType}
                    <br/>
                    <div>
                    <textarea readonly class="textareaContent">
                        ${note.content}
                    </textarea>
                    </div>
                </#if>
            </div>
        </#list>
    </div>

    <div id="nav">
        <dl>
            <dt><h2>目录：</h2></dt>
            <#list noteList as note>
                <dd><a href="#note_${note_index + 1}">${note_index + 1}、${note.title}</a></dd>
            </#list>
        </dl>
    </div>
</div>
</body>
</html>