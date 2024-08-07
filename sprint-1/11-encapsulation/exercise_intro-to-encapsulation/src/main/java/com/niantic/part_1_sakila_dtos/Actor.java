package com.niantic.part_1_sakila_dtos;

public class Actor
{
    private int actorId;
    private String firstName;
    private String lastName;

    public Actor()
    {

    }

    public Actor(int actorId, String firstName, String lastName)
    {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getActorId() {return actorId;}
    public void setActorId(int actorId) {this.actorId = actorId;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFullName() {return firstName + " " + lastName;}
    public void setFullName(String fullName)
    {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }
}