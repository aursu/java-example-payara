package com.github.aursu.payara.webapp.dao;

import com.github.aursu.payara.webapp.entities.Artist;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ArtistDao {

    @PersistenceContext
    EntityManager em;

    public List<Artist> findAll() {
        return em.createNamedQuery("Artist.findAll", Artist.class).getResultList();
    }

    public void addArtist(Artist a) {
        em.persist(a);
    }

    public void deleteArtist(Artist a) {
        Artist artist = em.find(Artist.class, a.getId());
        if (artist != null && artist.getAlbums().isEmpty()) {
            em.remove(artist);
        }
    }
}
