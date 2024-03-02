package jpabook.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item{
    // extends Item으로 상속받음

    private String artist;
    private String etc;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
