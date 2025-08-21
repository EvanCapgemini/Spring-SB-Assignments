package com.demo.model;

public class TraineeDTO {
    private Integer id;
    private String name;
    private String phoneNo;
    private DesktopDTO desktop;

    public TraineeDTO() {}
    public TraineeDTO(Integer id, String name, String phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public DesktopDTO getDesktop() { return desktop; }
    public void setDesktop(DesktopDTO desktop) { this.desktop = desktop; }

    @Override
    public String toString() {
        return "TraineeDTO [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo
             + ", desktop=" + desktop + "]";
    }
}
