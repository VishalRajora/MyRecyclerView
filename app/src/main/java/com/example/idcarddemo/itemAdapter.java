package com.example.idcarddemo;

public class itemAdapter
{
    String mName;
    String mImage;
    String age;
    String location;

    public itemAdapter()
    {

    }

    public itemAdapter(String mImage ,String mName, String age , String location) {
        this.mName = mName;
        this.mImage = mImage;
        this.age = age;
        this.location = location;


    }


    public String getmImage()
    {
        return mImage;
    }

    public void setmImage(String mImage)
    {
        this.mImage = mImage;
    }
    public String getmName()
    {
        return mName;
    }

    public void setmName(String mName)
    {
        this.mName = mName;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
