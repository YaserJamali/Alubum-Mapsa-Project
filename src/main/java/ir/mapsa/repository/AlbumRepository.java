package ir.mapsa.repository;

import ir.mapsa.model.Album;
import ir.mapsa.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository implements BaseRepository<Album, Long> {
    private static AlbumRepository instance;
    private SessionFactory sf;

    private Session session;

    private AlbumRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    public static AlbumRepository getInstance() {
        if (instance == null) {
            instance = new AlbumRepository();
            return instance;
        }
        return instance;
    }


    @Override
    public Album save(Album album) {
        session.getTransaction().begin();
        session.save(album);
        session.getTransaction().commit();
        return album;
    }

    @Override
    public Album update(Album album) {
        session.getTransaction().begin();
        session.update(album);
        session.getTransaction().commit();
        return album;
    }

    @Override
    public Album delete(Long id) {
        session.getTransaction().begin();
        Album album = findById(id);
        session.delete(album);
        session.getTransaction().commit();
        return album;
    }

    @Override
    public Album findById(Long id) {
        return session.get(Album.class, id);
    }

    @Override
    public List<Album> findByExample(String s) {
        TypedQuery<Album> query = session.createQuery("select a from albumEntity a where title like :titleName", Album.class);
        query.setParameter("titleName", "%" + s + "%");
        return query.getResultList();
    }

    public List<Album> findAll() {
        TypedQuery<Album> query = session.createQuery("select a from albumEntity a ", Album.class);
        return query.getResultList();

    }


}
