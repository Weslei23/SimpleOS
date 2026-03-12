package com.wsdev.simpleos.model;

@Embeddable
public class Address
{
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public Address( String street )
    {

    }

    public Address( String street, String zipcode, String state, String city, String country )
    {
        this.street = street;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet( String street )
    {
        this.street = street;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode( String zipcode )
    {
        this.zipcode = zipcode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry( String country )
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState( String state )
    {
        this.state = state;
    }
}
