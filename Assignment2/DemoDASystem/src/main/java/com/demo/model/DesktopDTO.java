package com.demo.model;

public class DesktopDTO {
    private String machineName;
    private String make;

    public DesktopDTO() {}
    public DesktopDTO(String machineName, String make) {
        this.machineName = machineName;
        this.make = make;
    }

    public String getMachineName() { return machineName; }
    public void setMachineName(String machineName) { this.machineName = machineName; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    @Override
    public String toString() {
        return "DesktopDTO [machineName=" + machineName + ", make=" + make + "]";
    }
}
