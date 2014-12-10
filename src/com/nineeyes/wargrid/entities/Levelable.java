package com.nineeyes.wargrid.entities;

/**
 * com.nineeyes.wargrid.entities
 */
public interface Levelable {
    public void levelUp(int levels);
    public int getLevel();
    public void setLevel(int level);
    public void modifyLevel(int level);
    public int getExperience();
    public void setExperience(int experience);
    public void modifyExperience(int experience);
    public int getExpCap();
    public void setExpCap(int expCap);
    public void modifyExpCap(int expCap);
}
