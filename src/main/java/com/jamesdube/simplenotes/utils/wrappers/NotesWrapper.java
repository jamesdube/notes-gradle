package com.jamesdube.simplenotes.utils.wrappers;

public class NotesWrapper {

    private Long id;

    private String text;

    public static NotesWrapper newInstance(String text) {
        NotesWrapper wrapper =  new NotesWrapper();
        wrapper.setText(text);
        return wrapper;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
