package com.jung.tthanguel.startTTHangeul.recycler;

public class SelectCountData {
    int count;
    boolean selected;

    public SelectCountData(int count, boolean selected) {
        this.count = count;
        this.selected= selected;
    }

    public int getCount() {
        return count;
    }
    public boolean getSelected() {
        return selected;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
