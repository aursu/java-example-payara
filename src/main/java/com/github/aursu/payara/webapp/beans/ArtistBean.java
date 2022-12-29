package com.github.aursu.payara.webapp.beans;

import com.github.aursu.payara.webapp.dao.ArtistDao;
import com.github.aursu.payara.webapp.entities.Artist;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ArtistBean implements Serializable {

    @EJB
    private ArtistDao artistDao;

    private Artist artist = new Artist();

    public List<Artist> getArtists() {
        return artistDao.findAll();
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void addArtist() {
        if (artist.getName() != null && !artist.getName().isBlank()) {
            artistDao.addArtist(artist);
            artist = new Artist();
        }
    }

    public void deleteArtist(Artist artist) {
        artistDao.deleteArtist(artist);
    }

    public String showAlbums(Artist artist) {
        this.artist = artist;
        return "albums_by_artist";
    }

    public String showArtists() {
        artist = new Artist();
        return "artists";
    }
}
