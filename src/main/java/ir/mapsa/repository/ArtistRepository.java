package ir.mapsa.repository;

import ir.mapsa.model.Artist;
import ir.mapsa.model.Song;
import ir.mapsa.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository implements BaseRepository<Artist, Long> {
    private static ArtistRepository instance;
    private SessionFactory sf;
    private Session session;

    private ArtistRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    public static ArtistRepository getInstance() {
        if (instance == null) {
            instance = new ArtistRepository();
            return instance;
        }
        return instance;
    }


    @Override
    public Artist save(Artist artist) {
        session.getTransaction().begin();
        session.save(artist);
        session.getTransaction().commit();
        return artist;
    }

    @Override
    public Artist update(Artist artist) {
        session.getTransaction().begin();
        session.update(artist);
        session.getTransaction().commit();
        return artist;
    }

    @Override
    public Artist delete(Long id) {
        session.getTransaction().begin();
        Artist artist = findById(id);
        session.delete(artist);
        session.getTransaction().commit();
        return artist;
    }

    @Override
    public Artist findById(Long id) {
        return session.get(Artist.class, id);
    }

    @Override
    public List<Artist> findByExample(String s) {
        TypedQuery<Artist> query = session.createQuery("select a from artistEntity a where name like :titleName", Artist.class);
        query.setParameter("titleName", "%" + s + "%");
        return query.getResultList();
    }

    @Override
    public List<Artist> findAll() {
        TypedQuery<Artist> query = session.createQuery("select a from artistEntity a ", Artist.class);
        return query.getResultList();
    }
}
