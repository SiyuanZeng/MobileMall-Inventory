package com.mindtree.mcse.mobilemall.domain.hibernateannotation;


public class Sequence {
    private String name;
    private int seqnum;
    
    public Sequence() {
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public int getSeqnum() {
        return this.seqnum;
    }
    
    public void setSeqnum(int newSeqnum) {
        this.seqnum = newSeqnum;
    }
    
    public void increment() {
        this.seqnum++;
    }
}
