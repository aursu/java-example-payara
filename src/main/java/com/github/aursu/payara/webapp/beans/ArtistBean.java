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

    public List<Artist> getArtists() {
        return artistDao.findAll();
    }
}
