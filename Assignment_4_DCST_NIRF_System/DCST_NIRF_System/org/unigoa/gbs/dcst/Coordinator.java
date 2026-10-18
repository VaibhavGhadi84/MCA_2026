package org.unigoa.gbs.dcst;

import java.io.Serializable;

public class Coordinator implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    public String coordinatorName;

    public Coordinator(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}