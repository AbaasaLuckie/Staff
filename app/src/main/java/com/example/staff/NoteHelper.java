package com.example.staff;
public class NoteHelper {
    public String sname;
    public String fname;
    public String email;
    public String tel;
    public String id;
    public String station;

    public NoteHelper() {
    }

    public NoteHelper(String getsname,String getfname,String getemail,String gettel,String getid,String getstation) {
        this.sname = getsname;
        this.fname = getfname;
        this.email = getemail;
        this.tel = gettel;
        this.id = getid;
        this.station = getstation;
    }


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}