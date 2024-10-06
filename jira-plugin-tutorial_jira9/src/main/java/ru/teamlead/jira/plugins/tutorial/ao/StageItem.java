package ru.teamlead.jira.plugins.tutorial.ao;

import net.java.ao.Entity;

public interface StageItem extends Entity {
    int getNum();
    String getName();

    void setNum(int value);
    void setName(String value);
}
