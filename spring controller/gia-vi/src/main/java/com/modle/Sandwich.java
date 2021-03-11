package com.modle;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private boolean lettuce;
    private boolean tomamto;
    private boolean mustard;
    private boolean sprouts;

    public Sandwich(boolean lettuce, boolean tomamto, boolean mustard, boolean sprouts) {
        this.lettuce = lettuce;
        this.tomamto = tomamto;
        this.mustard = mustard;
        this.sprouts = sprouts;
    }

    public Sandwich() {
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public boolean isTomamto() {
        return tomamto;
    }

    public void setTomamto(boolean tomamto) {
        this.tomamto = tomamto;
    }

    public boolean isMustard() {
        return mustard;
    }

    public void setMustard(boolean mustard) {
        this.mustard = mustard;
    }

    public boolean isSprouts() {
        return sprouts;
    }

    public void setSprouts(boolean sprouts) {
        this.sprouts = sprouts;
    }
}
