package harouane;

import com.github.javafaker.Faker;
import harouane.DAO.EventDAO;
import harouane.Entities.Event;
import harouane.Entities.EventType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("gestioneeventi");

    private static final Faker faker =new Faker();

    static Supplier<EventType> getRandomEventType=()->{
        Random num = new Random();
        if(num.nextInt(1, 2)==1) return EventType.PRIVATO;
        return EventType.PUBBLICO;
    };

    static Supplier<Integer> getRandomNumberPartecipant=()->{
        Random num = new Random();
        return num.nextInt(50, 250);

    };
    static Supplier<Event> getNewEvent=()->{
        return new Event(faker.book().title(), faker.date().birthday(), faker.howIMetYourMother().catchPhrase(), getRandomEventType.get(), getRandomNumberPartecipant.get());
    };

    public static void main(String[] args) {
        EntityManager em= emf.createEntityManager();
        EventDAO eventDAO= new EventDAO(em);
        Event event= getNewEvent.get();
        System.out.println(event);
        eventDAO.saveNewEvent(event);
        Event evToFind = eventDAO.getEventById(5);
        if (evToFind == null) System.out.println("Elemento non trovato!");
        else System.out.println("Elemento trovato: " + evToFind);

        eventDAO.deleteById(5);

        em.close();
        emf.close();
    }


}
