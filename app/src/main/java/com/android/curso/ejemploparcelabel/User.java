package com.android.curso.ejemploparcelabel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by salvador on 17/09/2017.
 */

public class User implements Parcelable {



    private String nombre;
    private String apellido;

    public User(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public User(Parcel parcel) {
        nombre=parcel.readString();
        apellido=parcel.readString();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getNombre().equals(user.getNombre())) return false;
        return getApellido().equals(user.getApellido());

    }

    @Override
    public int hashCode() {
        int result = getNombre().hashCode();
        result = 31 * result + getApellido().hashCode();
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(nombre);
        parcel.writeString(apellido);

    }

    public static final Parcelable.Creator<User> CREATOR=new Parcelable.Creator<User>(){

        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };
}
