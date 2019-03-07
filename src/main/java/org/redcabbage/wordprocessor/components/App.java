package org.redcabbage.wordprocessor.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.tools.Tool;

@Component
public class App {
    private Editor editor;
    private FileBrowser fileBrowser;
    private Spellchecker spellChecker;
    private Toolbar toolBar;

    public Editor getEditor() {
        return editor;
    }

    @Autowired
    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public FileBrowser getFileBrowser() {
        return fileBrowser;
    }

    @Autowired
    public void setFileBrowser(FileBrowser fileBrowser) {
        this.fileBrowser = fileBrowser;
    }

    public Spellchecker getSpellChecker() {
        return spellChecker;
    }

    @Autowired
    public void setSpellChecker(Spellchecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public Toolbar getToolBar() {
        return toolBar;
    }

    @Autowired
    public void setToolBar(Toolbar toolBar) {
        this.toolBar = toolBar;
    }
}
