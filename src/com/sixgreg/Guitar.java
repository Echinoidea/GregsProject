package com.sixgreg;

class Guitar {

    // Variables

    private String brandName = "";
    private String guitarName = "";

    private GuitarType guitarType;
    private PlayStyle playStyle;
    private Tuning tuning;
    private Effect effect;
    private Speed speed;

    // Getters and Setters

    String getBrandName() {
        return brandName;
    }

    void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    String getGuitarName() {
        return guitarName;
    }

    void setGuitarName(String guitarName) {
        this.guitarName = guitarName;
    }

    GuitarType getGuitarType() {
        return guitarType;
    }

    void setGuitarType(GuitarType guitarType) {
        this.guitarType = guitarType;
    }

    PlayStyle getPlayStyle() {
        return playStyle;
    }

    void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }

    Tuning getTuning() {
        return tuning;
    }

    void setTuning(Tuning tuning) {
        this.tuning = tuning;
    }

    Effect getEffect() {
        return effect;
    }

    void setEffect(Effect effect) {
        this.effect = effect;
    }

    Speed getSpeed() {
        return speed;
    }

    void setSpeed(Speed speed) {
        this.speed = speed;
    }

    /**
     * Default constructor
     */
    Guitar() {}
}
