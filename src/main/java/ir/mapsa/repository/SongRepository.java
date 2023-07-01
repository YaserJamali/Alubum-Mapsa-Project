package ir.mapsa.repository;

import ir.mapsa.model.Album;
import ir.mapsa.model.Song;
import ir.mapsa.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class SongRepository implements BaseRepository<Song,Long>{

    private static SongRepository instance;

    private final Session session;

    private SongRepository() {
        SessionFactory sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    public static SongRepository getInstance() {
        if (instance == null) {
            instance = new SongRepository();
            return instance;
        }
        return instance;
    }






    @Override
    public Song save(Song song) {
        session.getTransaction().begin();
        session.save(song);
        session.getTransaction().commit();
        return song;
    }

    @Override
    public Song update(Song song) {
        session.getTransaction().begin();
        session.update(song);
        session.getTransaction().commit();
        return song;
    }

    @Override
    public Song delete(Long id) {
        session.getTransaction().begin();
        Song song =findById(id);
        session.delete(song);
        session.getTransaction().commit();
        return song;
    }

    @Override
    public Song findById(Long id) {
        return session.get(Song.class, id);
    }

    @Override
    public List<Song> findByExample(String s) {
        TypedQuery<Song> query = session.createQuery("select s from songEntity s where title like :titleName", Song.class);
        query.setParameter("titleName", "%" + s + "%");
        return query.getResultList();
    }

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = session.createQuery("select s from songEntity s ", Song.class);
        return query.getResultList();
    }
}
